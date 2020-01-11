import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class MovieReader {

    //Returns hashmap movieID : movie title
    public HashMap<String, String> readAllTitles(String pathToMoviescsv) throws IOException {

        //Hashmap of movies id and titles
        HashMap<String,String> movies = new HashMap<String, String>();

        //Reading movies ids and titles
        BufferedReader br1 = new BufferedReader(new FileReader(pathToMoviescsv));
        String line1 = null;
        line1 = br1.readLine();

        while ((line1 = br1.readLine()) != null) {
            //Row to array of string
            String[] row2 = line1.split(",");
            movies.put(row2[1], row2[2]);
        }
        br1.close();
        return movies;
    }

    //Returns list of Movie items used by GUI table
    public List<Movie> readScoreMovies(String pathToMoviescsv) throws IOException {

        //List of movies to insert to gui form
        List<Movie> tableList = new ArrayList<>();

        //Reading movies ids and titles
        BufferedReader br1 = new BufferedReader(new FileReader(pathToMoviescsv));
        String line1 = null;
        line1 = br1.readLine();

        //Vector of movies ids to be scored by user
        Vector<Integer> toScoreID = new Vector<>();

        toScoreID.add(1); // Toy Story
        toScoreID.add(318); // Shawshank Redemption
        toScoreID.add(356); // Forrest Gump
        toScoreID.add(296); // Pulp Fiction
        toScoreID.add(593); // Silence of the Lambs
        toScoreID.add(2571); //	Matrix
        toScoreID.add(260); // Star Wars: Episode IV - A New Hope
        toScoreID.add(480); // Jurassic Park
        toScoreID.add(527); // Schindler's List
        toScoreID.add(110); //Braveheart
        toScoreID.add(2959); //	Fight Club
        toScoreID.add(72998); // Avatar
        toScoreID.add(89745); // Avengers,
        toScoreID.add(589); // Terminator 2: Judgment Day
        toScoreID.add(1198); //Indiana Jones and the Raiders of the Lost Ark
        toScoreID.add(50); //Usual Suspects
        toScoreID.add(4993); //Lord of the Rings: The Fellowship of the Ring
        toScoreID.add(858); //Godfather
        toScoreID.add(2858); // American Beauty
        toScoreID.add(780); // Independence Day
        toScoreID.add(150); // Apollo 13
        toScoreID.add(47); // Seven
        toScoreID.add(3578); // Gladiator
        toScoreID.add(344); //Ace Ventura: Pet Detective
        toScoreID.add(1193); //	One Flew Over the Cuckoo's Nest
        toScoreID.add(1265); // Groundhog Day
        toScoreID.add(1036); // Die Hard
        toScoreID.add(1214); // Alien
        toScoreID.add(6874); // Kill Bill: Vol. 1
        toScoreID.add(10); //GoldenEye

        while ((line1 = br1.readLine()) != null) {
            //Row to array of string
            String[] row2 = line1.split(",");

            //Adding movie to list user score movies
            Integer id = Integer.valueOf(row2[1]);
            if(toScoreID.contains(id)){
                Movie nextMovie = new Movie(row2[2], row2[1], 0);
                tableList.add(nextMovie);
            }
        }
        br1.close();
        return tableList;
    }
}
