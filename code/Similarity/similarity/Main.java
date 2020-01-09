import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException{

        /*
        //List of movies' ids which were scored by user
        ArrayList<Integer> userScoredMovies = new ArrayList<>();

        userScoredMovies.add(318);
        userScoredMovies.add(356);
        userScoredMovies.add(296);
        userScoredMovies.add(593);
        userScoredMovies.add(2571);
        userScoredMovies.add(260);
        userScoredMovies.add(480);
        userScoredMovies.add(527);
        userScoredMovies.add(110);
        userScoredMovies.add(1);
        userScoredMovies.add(2959);
        userScoredMovies.add(72998);
        userScoredMovies.add(89745);
        userScoredMovies.add(589);
        userScoredMovies.add(1198);
        userScoredMovies.add(50);
        userScoredMovies.add(4993);
        userScoredMovies.add(858);
        userScoredMovies.add(2858);
        userScoredMovies.add(780);
        userScoredMovies.add(150);
        userScoredMovies.add(47);
        userScoredMovies.add(3578);
        userScoredMovies.add(344);
        userScoredMovies.add(1193);
        userScoredMovies.add(1265);
        userScoredMovies.add(1036);
        userScoredMovies.add(1214);
        userScoredMovies.add(6874);
        userScoredMovies.add(10);

        //Calculating similarity matrix, from movie-user ratings table
        Similarity similarityMatrix = new Similarity(userScoredMovies);
        similarityMatrix.calculateSimilarity("/home/jan/Pulpit/ml-latest/ramka.csv");
        */

        //Tests
        HashMap<String,Double> test = new HashMap<String, Double>();
        Double ocena = Double.valueOf(0);
        HashMap<String,String> movies = new HashMap<String, String>();
        BufferedReader br1 = new BufferedReader(new FileReader("/home/jan/Pulpit/Movies.csv"));
        String line1 = null;
        line1 = br1.readLine();

        while ((line1 = br1.readLine()) != null) {


            //Row to array of string
            String[] row2 = line1.split(",");
            // Reading movie index from each row
            movies.put(row2[1],row2[2]);
        }


            test.put("1",0.0 ); // Toy Story
        test.put("318", 0.0); // Shawshank Redemption
        test.put("356",ocena); // Forrest Gump
        test.put("296", ocena); // Pulp Fiction
        test.put("593", ocena); // Silence of the Lambs
        test.put("2571", 0.0); // Matrix
        test.put("260", 10.0); // Star Wars IV
        test.put("480", ocena); // Jurassic Park
        test.put("527", ocena); // Schindler's List
        test.put("110", ocena); // Braveheart
        test.put("2959", ocena); // Fight Club
        test.put("72998", 10.0); // Avatar
        test.put("89745", 0.0); // Avengers
        test.put("589", ocena); // Terminator 2
        test.put("1198", ocena); // Indiana Jones and the Raiders of the Lost Ark)
        test.put("50", ocena); // Usual Suspects
        test.put("4993", ocena);// Lord of the Rings: The Fellowship of the Ring
        test.put("858", ocena); // Godfather
        test.put("2858", ocena); // American Beauty
        test.put("780", ocena); // Independence Day
        test.put("150", ocena); // Apollo 13
        test.put("47", ocena); // Seven
        test.put("3578", ocena); // Gladiator
        test.put("344", ocena); // Ace Ventura: Pet Detective
        test.put("1193", ocena); // One Flew Over the Cuckoo's Nest
        test.put("1265", ocena); // Groundhog Day
        test.put("1036", ocena); // Die Hard
        test.put("1214", ocena); // Alien
        test.put("6874", ocena); // Kill Bill: Vol. 1
        test.put("10", ocena); // GoldenEye
        Recomendation test1 = new Recomendation(test,"/home/jan/Pulpit/similarityMatrix.csv");
        Map<String,Double> wynik_test = test1.calcullateRecomendation(5);


        for (Map.Entry entry : wynik_test.entrySet()) {
            System.out.println(movies.get(entry.getKey()));
        }





    }

}
