package com.company;

import java.util.HashSet;
import java.util.Set;

/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
 */
public class No73_setMatrixZeros {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowZeroes = new HashSet<>();
        Set<Integer> columnZeroes = new HashSet<>();

        for(int i = 0; i < matrix.length; i ++)
        {
            for(int j = 0; j < matrix[0].length; j ++)
            {
                if(matrix[i][j] == 0)
                {
                    rowZeroes.add(i);
                    columnZeroes.add(j);
                }
            }
        }

        for(int i = 0; i < matrix.length; i ++)
        {
            for(int j = 0; j < matrix[0].length; j ++){
                if(rowZeroes.contains(i)) matrix[i][j] = 0;
                if(columnZeroes.contains(j)) matrix[i][j] = 0;
            }
        }

    }

    public void setZeroes2(int[][] matrix){

        Boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;

        for(int i = 0; i < R; i ++)
        {
            if(matrix[i][0] == 0){
                isCol = true;
            }

            for(int j = 1; j < C; j ++){
                if(matrix[i][j] == 0)
                {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < R; i ++)
        {
            for(int j = 1; j < C; j ++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                {
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int j = 0; j < C; j ++){
                matrix[0][j] = 0;
            }
        }

        if(isCol){
            for(int i = 0; i < R; i ++){
                matrix[i][0] = 0;
            }
        }
    }
}
