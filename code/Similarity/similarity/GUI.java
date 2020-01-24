import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//// ZDJETY LIMIT /////
public class GUI {

    public static void main(String[] args) throws IOException {

        //path to Movies.csv
        String moviesPath = System.getProperty("user.dir");
        moviesPath += "/code/Similarity/similarity/Movies.csv";

        //path to similaritymatrix
        String sMatrixPath = System.getProperty("user.dir");
        sMatrixPath += "/similarityMatrix_test.csv";

        JFrame frame = new JFrame("Movie Recommender");
        frame.setSize(new Dimension(1000, 600));

        //Preparing data for algorithm and app
        MovieReader movieReader = new MovieReader();
        HashMap<String, String> allTitles = movieReader.readAllTitles(moviesPath);
        List<Movie> moviesToGUI = movieReader.readScoreMovies(moviesPath);

        //GUI

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.BLUE);
        JLabel topText = new JLabel("Please score 10 movies");
        topPanel.add(topText, "Center");
        frame.getContentPane().add(topPanel, "North");

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());

        //Table with scores
        TableModel model = new TableModel(moviesToGUI);

        JTable table = new JTable(model);

        TableColumn col0 = table.getColumnModel().getColumn(0);
        col0.setPreferredWidth(98);

        table.setRowHeight(140);

        TableColumn col2 = table.getColumnModel().getColumn(2);

        col2.setPreferredWidth(200);
        col2.setCellEditor(new SliderEditor());
        col2.setCellRenderer(new CellRenderer());

        TableColumn col1 = table.getColumnModel().getColumn(1);
        col1.setPreferredWidth(400);

        JButton runPrediction = new JButton("Give prediction");
        JScrollPane forTable = new JScrollPane(table);
        runPrediction.setEnabled(true);

//        leftPanel.add(forTable, "North");
//        leftPanel.add(runPrediction, "South");

        JSplitPane splitLeft = new JSplitPane(JSplitPane.VERTICAL_SPLIT, forTable, runPrediction);
        splitLeft.setResizeWeight(0.9);
        leftPanel.add(splitLeft);
        splitLeft.setPreferredSize(new Dimension(800, 30));
        splitLeft.setVisible(true);
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());

        JTextPane output = new JTextPane();
        output.setFont(new Font("Serif", Font.BOLD, 25));
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        /// Centering
        output.setEditorKit(new MyEditorKit());
        SimpleAttributeSet attrs=new SimpleAttributeSet();
        StyleConstants.setAlignment(attrs,StyleConstants.ALIGN_CENTER);
        StyledDocument doc=(StyledDocument)output.getDocument();
        doc.setParagraphAttributes(0,doc.getLength()-1,attrs,false);



        rightPanel.add(output);

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);

        table.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                TableCellEditor tce = table.getCellEditor();
                if(tce != null){
                    int j = 0;
                    for (int i = 0; i < 30; i++) {
                        Movie scoredMovie = model.modelList.get(i);
                        if (scoredMovie.score>0){j+=1; }

                    }
                    if (j>9){
                        runPrediction.setEnabled(true);
                    }
                }

            }
        });


        frame.add(split);


        String finalSMatrixPath = sMatrixPath;
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

                Recomendation recomendation = new Recomendation(usersScores, finalSMatrixPath);
                try {

                    Map<String, Double> result = recomendation.calcullateRecomendation(10);


                    int i = 1;
                    for (String bestId:result.keySet()) {
                        String title = allTitles.get(bestId);
                        Document ins = output.getDocument();
                        ins.insertString(ins.getLength(),String.valueOf(i) + ". " + title + "\n",null);
                        i += 1;
                    }

                    result.clear();

                } catch (IOException | BadLocationException e1) {
                    e1.printStackTrace();
                }
            }
        });

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
