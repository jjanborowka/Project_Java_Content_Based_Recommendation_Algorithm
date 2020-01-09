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
        similarityMatrix.calculateSimilarity("/home/piotr/Pobrane/ramka.csv");
        */

        //Tests
        HashMap<String,Double> test = new HashMap<String, Double>();
        Double dupa = Double.valueOf(0);


        test.put("1", dupa);
        test.put("318", dupa);
        test.put("356",dupa);
        test.put("296", dupa);
        test.put("593", dupa);
        test.put("2571", dupa);
        test.put("260", dupa);
        test.put("480", dupa);
        test.put("527", Double.valueOf(7));
        test.put("110", dupa);
        test.put("2959", dupa);
        test.put("72998", dupa);
        test.put("89745", Double.valueOf(9));
        test.put("589", dupa);
        test.put("1198", Double.valueOf(3));
        test.put("50", dupa);
        test.put("4993", Double.valueOf(8));
        test.put("858", dupa);
        test.put("2858", dupa);
        test.put("780", dupa);
        test.put("150", dupa);
        test.put("47", Double.valueOf(2));
        test.put("3578", Double.valueOf(3));
        test.put("344", dupa);
        test.put("1193", Double.valueOf(1));
        test.put("1265", dupa);
        test.put("1036", dupa);
        test.put("1214", dupa);
        test.put("6874", dupa);
        test.put("10", dupa);
        Recomendation test1 = new Recomendation(test,"/home/jan/Pulpit/similarityMatrix.csv");
        Map<String,Double> wynik_test = test1.calcullateRecomendation(10);
        System.out.println(wynik_test);






    }

}
