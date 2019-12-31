import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException{

        //List of movies' ids which were scored by user
        ArrayList<Integer> userScoredMovies = new ArrayList<>();
        userScoredMovies.add(1);
        userScoredMovies.add(2);
        userScoredMovies.add(3);

        //Test
        Similarity test = new Similarity(userScoredMovies);
        //Calculating similarity matrix, from movie-user rating table
        test.calculateSimilarity("/home/piotr/Pobrane/test_csv.csv");

    }
}
