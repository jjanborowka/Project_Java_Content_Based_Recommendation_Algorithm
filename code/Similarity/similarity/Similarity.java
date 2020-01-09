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

        //Opening writer to append calculated similarities directly to csv file
        FileWriter writer = new FileWriter("/home/jan/Pulpit/similarityMatrix1.csv");

        //Additional reader to read all movies scored by user
        BufferedReader br1 = new BufferedReader(new FileReader(pathToCSV));

        //Adding user scored movies' indexes as first row
        br1.readLine();
        String line1 = null;
        writer.append("-");

        //Array (matrix) for rows of 30 user scored movies
        ArrayList<String []> userMovies = new ArrayList<>();

        while ((line1 = br1.readLine()) != null) {

            //Row to array of string
            String[] row1 = line1.split(",");

            //Checking if current row-movie is in 30 scored by user
            if(userScoreMoviesId.contains(Integer.valueOf(row1[0].substring(1, row1[0].length()-1)))) {

                //Getting current movie index from first place of each row
                //because it's read as "1", using substring
                String movieIndex1 = row1[1];
                writer.append(",");
                writer.append(movieIndex1);

                //Appending to array
                userMovies.add(row1);
            }
        }
        writer.append("\n");

        //Opening reader which will read rows with all movies
        BufferedReader br2 = new BufferedReader(new FileReader(pathToCSV));
        br2.readLine();
        String line = null;

        //Start of br2 reading
        while ((line = br2.readLine()) != null) {

            //Row to array of string
            String[] row = line.split(",");

            //Getting current movie index from first place of each row
            //because it's read as "1", using substring
            String movieIndex = row[1];

            //Starting new line in result csv with movie index
            writer.append(movieIndex);

            //Iterating through user scored movies
            for (int i = 0; i < userMovies.size(); i++) {

                //Calculating cosine similarity
                int n = row.length;

                double dotProduct = 0.0;
                double normA = 0.0;
                double normB = 0.0;

                //Getting next user scored movie row
                String[] row2 = userMovies.get(i);

                //Iterating through all values of ratings given by users
                //which means iterating the rows
                for (int j = 2; j < n; j++) {

                    //Vectors used to calculate cosine similarity
                    //must contain only these ratings which were given
                    //by one user to both movies
                    if (!(row[j].equals("NA")) & !(row2[j].equals("NA"))) {

                        //String to double
                        double val = Double.valueOf(row[j]);
                        double val2 = Double.valueOf(row2[j]);

                        //Calculating dot product and norms
                        dotProduct += val * val2;
                        normA += Math.pow(val, 2);
                        normB += Math.pow(val2, 2);
                    }
                }

                //Final similarity of pair of movies
                double similarity = dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));

                //Writing value to csv
                writer.append(",");
                writer.append(String.valueOf(similarity));
            }

            //After calculating all values for pairs of one movie and all scored by user
            //starting new line in csv
            writer.append("\n");
        }

        //Closing br1 after reading all movies and closing writer
        br2.close();
        writer.close();
        br1.close();
    }

}
