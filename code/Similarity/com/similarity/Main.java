package com.similarity;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException{

//        CSVreader test = new CSVreader("/home/piotr/Pobrane/ramka.csv");
//        String[][] matrix = test.readCSV();

        Double[][] test = new Double[6][4];

        test[1][0] = 1.0;
        test[2][0] = 2.0;
        test[3][0] = 3.0;
        test[4][0] = 4.0;
        test[5][0] = 5.0;


        test[0][1] = 1.0;
        test[0][2] = 2.0;
        test[0][3] = 3.0;

        test[1][1] = 5.0;
        test[1][2] = 2.0;
        test[1][3] = 0.0;

        test[2][1] = 3.0;
        test[2][2] = 3.0;
        test[2][3] = 1.0;

        test[3][1] = 0.0;
        test[3][2] = 2.0;
        test[3][3] = 2.0;

        test[4][1] = 1.0;
        test[4][2] = 3.0;
        test[4][3] = 0.0;

        test[5][1] = 4.0;
        test[5][2] = 0.0;
        test[5][3] = 5.0;



        ArrayList<Integer> userInputMoviesId = new ArrayList<>();
        userInputMoviesId.add(1);

        userInputMoviesId.add(3);

        com.similarity.SimilarityMatrix alg_test = new com.similarity.SimilarityMatrix(userInputMoviesId);

        Double[][] wynik = alg_test.calculateSimilarityMatrix(test);

        for (int i = 0; i < wynik.length; i++) {
            for (int j = 0; j < wynik[0].length; j++) {
                System.out.println(wynik[i][j]);
            }
        }
    }
}
