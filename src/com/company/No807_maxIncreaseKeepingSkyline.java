package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class No807_maxIncreaseKeepingSkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int result = 0;
        List<Integer> LeftToRight = new ArrayList<Integer>();
        List<Integer> TopToBottomn = new ArrayList<Integer>();

        //step1: prepare the skyline list
        int line = grid.length;
        int row = grid[0].length;

        for(int i = 0; i < line; i ++)
        {
           LeftToRight.add(Arrays.stream(grid[i]).max().getAsInt());
           System.out.println(LeftToRight.get(i));
        }


        for(int i = 0; i < row; i ++)
        {
            int maxTemp = 0;
            for(int j = 0; j < line; j ++)
            {
                maxTemp = maxTemp > grid[j][i] ? maxTemp: grid[j][i];
            }
            TopToBottomn.add(maxTemp);
            System.out.println(TopToBottomn.get(i));
        }

        //step2: calculate the return value
        for(int i = 0; i < line; i ++)
        {
            for(int j= 0; j < row; j ++)
            {
                result += (LeftToRight.get(i) < TopToBottomn.get(j)? LeftToRight.get(i): TopToBottomn.get(j)) - grid[i][j];
            }
        }
        return result;
    }
}
