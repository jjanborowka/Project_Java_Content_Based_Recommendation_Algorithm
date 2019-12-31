import java.io.*;
import java.util.ArrayList;

public class Similarity {

    //IDs of movies which user scores
    ArrayList<Integer> userScoreMoviesId;

    public Similarity(ArrayList<Integer> userScoreMoviesId) {
        this.userScoreMoviesId = userScoreMoviesId;
    }

    //Method for calculating similarity matrix
    void calculateSimilarity(String pathToCSV) throws IOException {

        //Opening of first reader which will read rows with movies scored by user (30 movies)
        BufferedReader br1 = new BufferedReader(new FileReader(pathToCSV));
        BufferedReader br3 = new BufferedReader(new FileReader(pathToCSV));
        //tutaj omijam pierwsza linie, nwm w sumie chyba tak zostanie
        br1.readLine();
        String line = null;

        //Opening writer to append calculated similarities directly to csv file
        FileWriter writer = new FileWriter("/home/jan/Pulpit/wynik.csv");

        //Adding movieindex as firs rwo
        br3.readLine();
        String line11 = null;
        writer.append("-");
        writer.append(",");
        while ((line11 = br3.readLine()) != null) {

            //Row to array of string
            String[] row1 = line11.split(",");
            //Getting current movie index from first place of each row
            //because it's read as "1", using substring
            String movieIndex1 = row1[0].substring(1, row1[0].length()-1);
            writer.append(movieIndex1);
            writer.append(",");
        }
        writer.append("\n");

        //Start of br1 reading
        while ((line = br1.readLine()) != null) {

            //Row to array of string
            String[] row = line.split(",");

            //Getting current movie index from first place of each row
            //because it's read as "1", using substring
            String movieIndex = row[0].substring(1, row[0].length()-1);

            //Checking if current row-movie is in 30 scored by user
            if(userScoreMoviesId.contains(Integer.valueOf(movieIndex))){

                //Starting new line in result csv with movie index
                writer.append(movieIndex + ",");

                //Start of br2 reading to go over all movies to calculate
                //cosine similarity between movie scored by user and all another
                BufferedReader br2 = new BufferedReader(new FileReader(pathToCSV));
                br2.readLine();
                String line2 = null;

                while ((line2 = br2.readLine()) != null) {

                    String[] row2 = line2.split(",");

                    //Calculating cosine similarity
                    int n = row.length;

                    double dotProduct = 0.0;
                    double normA = 0.0;
                    double normB = 0.0;

                    //Iterating through all values of ratings given by users
                    //which means iterating the rows
                    for (int i = 1; i < n; i++) {

                        //Vectors used to calculate cosine similarity
                        //must contain only these ratings which were given
                        //by one user to both movies
                        if(!(row[i].equals("NA")) & !(row2[i].equals("NA"))){

                            //String to double
                            double val = Double.valueOf(row[i]);
                            double val2 = Double.valueOf(row2[i]);

                            //Calculating dot product and norms
                            dotProduct += val * val2;
                            normA += Math.pow(val, 2);
                            normB += Math.pow(val2, 2);
                        }
                    }

                    //Final similarity of pair of movies
                    double similarity = dotProduct/(Math.sqrt(normA)*Math.sqrt(normB));

                    //Writing value to csv
                    writer.append(String.valueOf(similarity));
                    writer.append(",");
                }
                //After calculating similarity between ones of movie scored by user and all
                //another closing reader which reads them, first reader will move to next movie
                //scored by user and br2 will be started again
                writer.append("\n");
                br2.close();
            }

        }
        //Closing br1 after reading all movies scored by user and closing writer
        br1.close();
        writer.close();
    }

}
