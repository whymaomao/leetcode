package com.company;

import java.util.*;

public class SegmentTree {
    public static int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        Arrays.stream(people).
                forEach(pe -> {
                    System.out.println(pe[0] + " -- " + pe[1]);
                });

        int[][] result = new int[len][2];
        int[] flagArray = new int[len];
        for(int i = 0; i < len; i ++ ) {
            int pos = people[i][1];
            int targetPos = 0;
            for(int j = 0; j < len; j ++ ) {
                if(flagArray[j] == 0) {
                    if(targetPos == pos) {
                        flagArray[j] = 1;
                        result[j] = new int[] {people[i][0], people[i][1]};
                        break;
                    } else {
                        targetPos ++;
                    }
                }
            }

        }

        return result;

    }

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] result = reconstructQueue(people);
        Arrays.stream(result).
                forEach(pe -> {
                    System.out.println(pe[0] + " -- " + pe[1]);
                });

    }

    public int cherryPickup(int[][] grid) {
        int result = 0;
        int gridRow = grid.length;
        int gridColumn = grid[0].length;
        int[][] dpCherry = new int[gridRow + 1][gridColumn + 1];

        for(int i = 0; i < gridRow; i ++) {
            for(int j = 0; j < gridColumn; j ++) {
                if(grid[i][j] == -1) {
                    dpCherry[i+1][j+1] = -1;
                }

                if(dpCherry[i][j + 1] == -1 && dpCherry[i+1][j] == -1) {
                    return 0;
                }


            }
        }
        return result;
    }
}
