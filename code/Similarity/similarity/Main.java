import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException{

        //Recomen_tests.test();
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
        HashMap<String,String> movies = new HashMap<String, String>();

        BufferedReader br1 = new BufferedReader(new FileReader("/home/jan/Pulpit/Movies.csv"));
        String line1 = null;
        line1 = br1.readLine();
        while ((line1 = br1.readLine()) != null) {
            //Row to array of string
            String[] row2 = line1.split(",");
           movies.put(row2[1],row2[2]);}

        br1.close();
        HashMap<String,Double> test = new HashMap<String, Double>();
        Double dana = Double.valueOf(0);


        test.put("1", 0.0); // Toy Story
        test.put("318", dana); // Shawshank Redemption
        test.put("356",dana);// Forrest Gump
        test.put("296", 5.0);//Pulp Fiction
        test.put("593", dana);//Silence of the Lambs,
        test.put("2571", dana);//	Matrix,
        test.put("260", 0.0);//Star Wars: Episode IV - A New Hope
        test.put("480", dana);//Jurassic Park
        test.put("527", 0.0); // Schindler's List
        test.put("110", dana);//Braveheart
        test.put("2959", 0.0);//	Fight Club
        test.put("72998", 0.0);//	Avatar
        test.put("89745", dana);//Avengers,
        test.put("589", dana);//Terminator 2: Judgment Day
        test.put("1198", dana);//Indiana Jones and the Raiders of the Lost Ark
        test.put("50", dana);//Usual Suspects
        test.put("4993",0.0);//Lord of the Rings: The Fellowship of the Ring,
        test.put("858", dana);// Godfather,
        test.put("2858", dana);// American Beauty
        test.put("780", dana);// Independence Day
        test.put("150", dana);// Apollo 13
        test.put("47", 0.0);// Seven
        test.put("3578", 0.0);// Gladiator
        test.put("344", dana);// Ace Ventura: Pet Detective
        test.put("1193", dana);// One Flew Over the Cuckoo's Nest
        test.put("1265", dana);//Groundhog Day
        test.put("1036", dana);//Die Hard
        test.put("1214", dana);//Alien
        test.put("6874", 0.0);//Kill Bill: Vol. 1
        test.put("10", dana);//GoldenEye
        Recomendation test1 = new Recomendation(test,"/home/jan/Pulpit/similarityMatrix_test.csv");
        Map<String,Double> wynik_test = test1.calcullateRecomendation(10);
        for (Map.Entry entry : wynik_test.entrySet()) {
            System.out.println(movies.get(entry.getKey()));
        }






    }

}
