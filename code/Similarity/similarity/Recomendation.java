import javax.xml.crypto.dom.DOMCryptoContext;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recomendation {
    // I asume if user dont rate movies form selected 30 their score = 0
    // Class works base on map maovieId : UserScore
    // Map always have length of 30
    // nwm jak bedo zapisywane rekomendacje powiedzmy ze dooble
    HashMap<String, Double> usersScores;
    String pathToCsv;

    public Recomendation(HashMap<String, Double> usersScores, String pathToCsv) {
        this.usersScores = usersScores;
        this.pathToCsv = pathToCsv;


    }

    // This method calculate recomandation
    public Map<String, Double> calcullateRecomendation(int number_of_recomendation) throws IOException {
        HashMap<String, Double> zwrot = new HashMap<String, Double>();

        // Open file connection
        BufferedReader br1 = new BufferedReader(new FileReader(pathToCsv));
        // Creat List of selected movie
        ArrayList<String> selected_movie = new ArrayList<String>();
        for (Map.Entry entry : usersScores.entrySet()){
            if ((Double) entry.getValue() >0) {
                selected_movie.add(String.valueOf(entry.getKey()));
            }
        }

        // First Row of 30 selected movieId
        String line1 = null;
        line1 = br1.readLine();
        String[] MoviesId = line1.split(",");
        // indexing form 1 becous 0 is "-"
        int j =  0 ;
        while ((line1 = br1.readLine()) != null) {
            j += 1 ;
            //Row to array of string
            String[] row2 = line1.split(",");
            // Reading movie index from each row
            String movieIndex1 = row2[0];


            // Callculating recomendation
            Double sum = Double.valueOf(0);
            Double sum_rate= Double.valueOf(0);

            for (int i = 1; i < row2.length; i++) {
                // Geting userscore mvoie
                Double userscore = usersScores.get(MoviesId[i]);
                sum_rate += (Double.valueOf(userscore) * Double.valueOf(row2[i]));
                if (!(usersScores.get(MoviesId[i]).equals(Double.valueOf(0))))  {
                    sum += Double.valueOf(row2[i]);}
            }
            //Calculating final prediction for selected movie
            Double final_prediction = sum_rate ;

            // Adding to selected recomendation

            if  (!(selected_movie.contains(movieIndex1))) {
                // not enough movie was alredy selected
                if (zwrot.size() < number_of_recomendation) {
                    zwrot.put(movieIndex1, final_prediction);
                } else {
                    // Calcullating max and minimal value in alredy recomendet
                    Double min = Double.valueOf(100000);

                    String min_key = "-";
                    for (Map.Entry entry : zwrot.entrySet()) {
                        if ((Double) entry.getValue() < min) {
                            min = (Double) entry.getValue();
                            min_key = (String) entry.getKey();
                        }
                    }
                    // Finally adding if its nessesery
                    if (min < final_prediction) {
                        zwrot.remove(min_key);
                        zwrot.put(movieIndex1, final_prediction);
                    }

                }
            }

        }
        br1.close();
        return zwrot;
    }
}


