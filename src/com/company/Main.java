package com.company;
import java.util.*;
import java.util.stream.Collectors;

public class Main{

    public static void main(String[] args) {

        No977_sortedSquares solution = new No977_sortedSquares();
        int[] input = {-4, -1, 0,3 ,10};
        int[] result = solution.sortedSquares(input);
        for(int i = 0; i < input.length; i ++)
            System.out.println(result[i]);
    }


}
