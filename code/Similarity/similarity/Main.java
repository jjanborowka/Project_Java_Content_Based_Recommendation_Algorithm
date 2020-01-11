import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.util.*;

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

//        //List of movies to insert to gui form
//        List<Movie> tableList = new ArrayList<>();
//
//        //Hashmap of movies id and titles
//        HashMap<String,String> movies = new HashMap<String, String>();
//
//        //Vector of movies ids to be scored by user
//        Vector<Integer> toScoreID = new Vector<>();
//
//        toScoreID.add(1); // Toy Story
//        toScoreID.add(318); // Shawshank Redemption
//        toScoreID.add(356); // Forrest Gump
//        toScoreID.add(296); // Pulp Fiction
//        toScoreID.add(593); // Silence of the Lambs
//        toScoreID.add(2571); //	Matrix
//        toScoreID.add(260); // Star Wars: Episode IV - A New Hope
//        toScoreID.add(480); // Jurassic Park
//        toScoreID.add(527); // Schindler's List
//        toScoreID.add(110); //Braveheart
//        toScoreID.add(2959); //	Fight Club
//        toScoreID.add(72998); // Avatar
//        toScoreID.add(89745); // Avengers,
//        toScoreID.add(589); // Terminator 2: Judgment Day
//        toScoreID.add(1198); //Indiana Jones and the Raiders of the Lost Ark
//        toScoreID.add(50); //Usual Suspects
//        toScoreID.add(4993); //Lord of the Rings: The Fellowship of the Ring
//        toScoreID.add(858); //Godfather
//        toScoreID.add(2858); // American Beauty
//        toScoreID.add(780); // Independence Day
//        toScoreID.add(150); // Apollo 13
//        toScoreID.add(47); // Seven
//        toScoreID.add(3578); // Gladiator
//        toScoreID.add(344); //Ace Ventura: Pet Detective
//        toScoreID.add(1193); //	One Flew Over the Cuckoo's Nest
//        toScoreID.add(1265); // Groundhog Day
//        toScoreID.add(1036); // Die Hard
//        toScoreID.add(1214); // Alien
//        toScoreID.add(6874); // Kill Bill: Vol. 1
//        toScoreID.add(10); //GoldenEye
//
//        //Reading movies ids and titles
//        BufferedReader br1 = new BufferedReader(new FileReader("/home/piotr/IdeaProjects/Projekt_java/code/Similarity/similarity/Movies.csv"));
//        String line1 = null;
//        line1 = br1.readLine();
//
//        while ((line1 = br1.readLine()) != null) {
//            //Row to array of string
//            String[] row2 = line1.split(",");
//            movies.put(row2[1], row2[2]);
//            //Adding movie to list user score movies
//            int id = Integer.valueOf(row2[1]);
//            if(toScoreID.contains(id)){
//                Movie nextMovie = new Movie(row2[2], id, 0);
//                tableList.add(nextMovie);
//            }
//        }
//        br1.close();


//        HashMap<String,Double> test = new HashMap<String, Double>();
//        Double dana = Double.valueOf(0);
//
//        test.put("1", 0.0); // Toy Story
//        test.put("318", dana); // Shawshank Redemption
//        System.out.println(test.toString());
//        test.put("356",dana);// Forrest Gump
//        test.put("296", 1.0);//Pulp Fiction
//        test.put("593", dana);//Silence of the Lambs,
//        test.put("2571", dana);//	Matrix,
//        test.put("260", 1.0);//Star Wars: Episode IV - A New Hope
//        test.put("480", dana);//Jurassic Park
//        test.put("527", 0.0); // Schindler's List
//        test.put("110", dana);//Braveheart
//        test.put("2959", 10.0);//	Fight Club
//        test.put("72998", 1.0);//	Avatar
//        test.put("89745", dana);//Avengers,
//        test.put("589", dana);//Terminator 2: Judgment Day
//        test.put("1198", dana);//Indiana Jones and the Raiders of the Lost Ark
//        test.put("50", dana);//Usual Suspects
//        test.put("4993",1.0);//Lord of the Rings: The Fellowship of the Ring,
//        test.put("858", dana);//Godfather,
//        test.put("2858", dana);//American Beauty
//        test.put("780", dana);//Independence Day
//        test.put("150", dana);//Apollo 13
//        test.put("47", 10.0);//Seven
//        test.put("3578", 10.0);//Gladiator
//        test.put("344", dana);//Ace Ventura: Pet Detective
//        test.put("1193", dana);//	One Flew Over the Cuckoo's Nest
//        test.put("1265", dana);//Groundhog Day
//        test.put("1036", dana);//Die Hard
//        test.put("1214", dana);//Alien
//        test.put("6874", dana);//Kill Bill: Vol. 1
//        test.put("10", dana);//GoldenEye
//        Recomendation test1 = new Recomendation(test,"/home/piotr/IdeaProjects/zpoif-projekt-2019-rekomender/SimilarityMatrix/similarityMatrix.csv");
//        Map<String,Double> wynik_test = test1.calcullateRecomendation(10);
//        for (Map.Entry entry : wynik_test.entrySet()) {
//            System.out.println(movies.get(entry.getKey()));
//        }






    }

}
