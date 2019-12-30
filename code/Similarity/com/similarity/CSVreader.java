package com.similarity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVreader {

    //Path to csv with user-movie rating matrix
    String path;

    public CSVreader(String path) {
        this.path = path;
    }

    public String[][] readCSV() throws IOException {

        List<String[]> rowList = new ArrayList<String[]>();
        BufferedReader br = new BufferedReader(new FileReader(this.path));
        String line;

        while ((line = br.readLine()) != null) {
            String[] lineItems = line.split(",");
            rowList.add(lineItems);

        }
        br.close();

        String[][] matrix = new String[rowList.size()][];
        for (int i = 0; i < rowList.size(); i++) {
            String[] row = rowList.get(i);
            matrix[i] = row;
        }
        return matrix;
    }

    //DOKONCZYC DOPASOWANE DO CSV-KI
    public Double[][] stringMatrixToDouble(String[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length-1;
        Double[][] result = new Double[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 2; j < n; j++) {
                if(i==0 & j==1){
                    result[0][0] = -1.0;
                }
                else {
                    if (!matrix[i][j].equals("NA")) {
                        result[i][j] = Double.valueOf(matrix[i][j]);
                    } else {
                        result[i][j] = 0.0;
                    }
                }
            }
        }
        return result;
    }
}
