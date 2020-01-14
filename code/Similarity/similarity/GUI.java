import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GUI {

    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame("Movie Recommender");
        frame.setSize(new Dimension(1000, 600));

        //Preparing data for algorithm and app
        MovieReader movieReader = new MovieReader();
        HashMap<String, String> allTitles = movieReader.readAllTitles("/home/piotr/IdeaProjects/Projekt_java/code/Similarity/similarity/Movies.csv");
        List<Movie> moviesToGUI = movieReader.readScoreMovies("/home/piotr/IdeaProjects/Projekt_java/code/Similarity/similarity/Movies.csv");

        //GUI
        JPanel topPanel = new JPanel();
        JLabel topText = new JLabel("Please score 10 movies");
        topPanel.add(topText, "Center");
        frame.getContentPane().add(topPanel, "North");

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());

        //Table with scores
        TableModel model = new TableModel(moviesToGUI);
        JTable table = new JTable(model);
        table.setRowHeight(50);

        TableColumn col2 = table.getColumnModel().getColumn(1);

        col2.setPreferredWidth(200);
        col2.setCellEditor(new SliderEditor());
        col2.setCellRenderer(new CellRenderer());

        TableColumn col1 = table.getColumnModel().getColumn(0);
        col1.setPreferredWidth(400);

        JButton runPrediction = new JButton("Give prediction");



        JScrollPane forTable = new JScrollPane(table);

//        leftPanel.add(forTable, "North");
//        leftPanel.add(runPrediction, "South");

        JSplitPane splitLeft = new JSplitPane(JSplitPane.VERTICAL_SPLIT, forTable, runPrediction);
        leftPanel.add(splitLeft, "North");

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());

        JTextArea output = new JTextArea();
        rightPanel.add(output, "Center");

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);

        frame.add(split);

        runPrediction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                output.setText("");

                //READING SCORES
                HashMap<String, Double> usersScores = new HashMap<>();

                for (int i = 0; i < 30; i++) {
                    Movie scoredMovie = model.modelList.get(i);
                    usersScores.put(scoredMovie.getId(), scoredMovie.getScore()/2);
                }

                Recomendation recomendation = new Recomendation(usersScores, "/home/piotr/IdeaProjects/Projekt_java/similarityMatrix_test.csv");
                try {

                    Map<String, Double> result = recomendation.calcullateRecomendation(10);


                    int i = 1;
                    for (String bestId:result.keySet()) {
                        String title = allTitles.get(bestId);
                        output.append(String.valueOf(i) + ". " + title + "\n");
                        i += 1;
                    }

                    result.clear();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
