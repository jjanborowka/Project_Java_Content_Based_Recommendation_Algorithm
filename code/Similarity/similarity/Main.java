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


        HashMap<String,Double> test = new HashMap<String, Double>();
        Double dupa = Double.valueOf(0);


        test.put("1", dupa); // Toy Story
        test.put("318", dupa); // Shawshank Redemption
        test.put("356",dupa);// Forrest Gump
        test.put("296", dupa);//Pulp Fiction
        test.put("593", dupa);//Silence of the Lambs,
        test.put("2571", dupa);//	Matrix,
        test.put("260", dupa);//Star Wars: Episode IV - A New Hope
        test.put("480", dupa);//Jurassic Park
        test.put("527", Double.valueOf(7)); // Schindler's List
        test.put("110", dupa);//Braveheart
        test.put("2959", dupa);//	Fight Club
        test.put("72998", dupa);//	Avatar
        test.put("89745", Double.valueOf(9));//Avengers,
        test.put("589", dupa);//Terminator 2: Judgment Day
        test.put("1198", Double.valueOf(3));//Indiana Jones and the Raiders of the Lost Ark
        test.put("50", dupa);//Usual Suspects
        test.put("4993", Double.valueOf(8));//Lord of the Rings: The Fellowship of the Ring,
        test.put("858", dupa);//Godfather,
        test.put("2858", dupa);//American Beauty
        test.put("780", dupa);//Independence Day
        test.put("150", dupa);//Apollo 13
        test.put("47", Double.valueOf(2));//Seven
        test.put("3578", Double.valueOf(3));//Gladiator
        test.put("344", dupa);//Ace Ventura: Pet Detective
        test.put("1193", Double.valueOf(1));//	One Flew Over the Cuckoo's Nest
        test.put("1265", dupa);//Groundhog Day
        test.put("1036", dupa);//Die Hard
        test.put("1214", dupa);//Alien
        test.put("6874", dupa);//Kill Bill: Vol. 1
        test.put("10", dupa);//GoldenEye
        Recomendation test1 = new Recomendation(test,"/home/jan/Pulpit/similarityMatrix.csv");
        Map<String,Double> wynik_test = test1.calcullateRecomendation(10);
        for (Map.Entry entry : wynik_test.entrySet()) {
            System.out.println(movies.get(entry.getKey()));
        }






    }

}
