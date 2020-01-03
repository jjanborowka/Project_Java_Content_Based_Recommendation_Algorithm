import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Recomendation {
    // I assume if user dont rate movies form selected 30 their score = 0
    // Class works base on map maovieId : UserScore
    // Map always have length of 30
    // nwm jak bedo zapisywane rekomendacje powiedzmy ze dooble
    HashMap<String, Double> usersScores;
    String pathToCsv;

    public Recomendation(HashMap<String, Double> usersScores, String pathToCsv) {
        this.usersScores = usersScores;
        this.pathToCsv = pathToCsv;


    }

    // This method calculates recommendation
    public Map<String, Double> calcullateRecomendation(int number_of_recomendation) throws IOException {
        HashMap<String, Double> result = new HashMap<>();

        // Open file connection
        BufferedReader br1 = new BufferedReader(new FileReader(pathToCsv));

        // First Row of 30 selected movieId
        String line1 = null;
        line1 = br1.readLine();
        String[] MoviesId = line1.split(",");

        // indexing from 1 because 0 is "-"
        int j =  0;

        while ((line1 = br1.readLine()) != null) {

            j += 1;

            //Row to array of string
            String[] row2 = line1.split(",");
            // Reading movie index from each row
            String movieIndex1 = row2[0];


            // Calculating recommendation
            Double sum = 0.0;
            Double sum_rate = 0.0;

            for (int i = 1; i < 31; i++) {

                // Getting movie's user score
                Double userscore = usersScores.get(MoviesId[i]);

                sum_rate += (userscore * Double.valueOf(row2[i]));

                if (!(usersScores.get(MoviesId[i]).equals(0.0))) {
                    sum += Double.valueOf(row2[i]);
                }
            }
            //Calculating final prediction for selected movie
            Double final_prediction = sum_rate / sum;

            // Adding to selected recommendation

            // not enough movie was already selected
            if (result.size() < number_of_recomendation) {
                result.put(movieIndex1, final_prediction);
            }
            else {
                // Calculating max and minimal value in already recommended
                Double min = 100.0;

                String min_key = "-";
                for (Map.Entry entry : result.entrySet()) {
                    if ((Double) entry.getValue() < min) {
                        min = (Double) entry.getValue();
                        min_key = (String) entry.getKey();
                    }
                }
                // Finally adding if its necessary
                if (min < final_prediction) {
                    result.remove(min_key);
                    result.put(movieIndex1, final_prediction);
                }
            }
        }

        return result;
    }
}


