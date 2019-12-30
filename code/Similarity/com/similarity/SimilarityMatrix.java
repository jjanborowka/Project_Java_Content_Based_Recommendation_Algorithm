package com.similarity;

import java.util.ArrayList;

public class SimilarityMatrix {

    //ID of movies which user scores
    ArrayList<Integer> userScoreFilmsId;

    public SimilarityMatrix(ArrayList<Integer> userScoreFilmsId) {
        this.userScoreFilmsId = userScoreFilmsId;
    }


    Double[][] calculateSimilarityMatrix(Double[][] ratingsMatrix){

        //First dimension of result matrix: size of user's input movies
        int u = userScoreFilmsId.size();

        //Second dimension: number of all movies
        int n = ratingsMatrix[0].length;

        //Creating result matrix
        Double[][] result = new Double[u+1][n];

        //Row names - user scored movies' ids
        for (int i = 1; i < u+1; i++) {
            result[i][0] = Double.valueOf(userScoreFilmsId.get(i-1));
        }

        //Col names
        for (int i = 1; i < n; i++) {
            result[0][i] = Double.valueOf(i);
        }

        //Calculating similarities based on user-movie ratings matrix

        //Pointer of current user scored movie index in result matrix
        int pointer = 1;

        //Loops going through all pairs of user scored movies
        //and all movies from dataset
        for (int userMovie: userScoreFilmsId) {
            for (int i = 1; i < n; i++) {

                //Calculation of single cosine similarity between
                //two movies
                double dotProduct = 0.0;
                double normA = 0.0;
                double normB = 0.0;
                for (int j = 1; j < ratingsMatrix.length; j++) {
                    if((ratingsMatrix[j][userMovie] != 0.0) & (ratingsMatrix[j][i] != 0.0)){
                        dotProduct += ratingsMatrix[j][userMovie] * ratingsMatrix[j][i];
                        normA += Math.pow(ratingsMatrix[j][userMovie], 2);
                        normB += Math.pow(ratingsMatrix[j][i], 2);
                    }
                }
                Double similarity = dotProduct/(Math.sqrt(normA)*Math.sqrt(normB));

                result[pointer][i] = similarity;

            }
            pointer += 1;
        }
    return result;
    }
}
