package com.company;

import java.util.Arrays;
import java.util.Stack;

public class week_Aug {


    static public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        if(value < a[0]) {
            return 0;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid + 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high + 1;
    }

    static public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] sumArray = new int[nums.length];
        int result = 0;
        for(int i = 0; i < nums.length; i ++) {
            result  += nums[i];
            sumArray[i] = result;
        }
        int[] anw = new int[queries.length];
        for(int i = 0; i < queries.length; i ++) {
            anw[i] = bsearch(sumArray, nums.length, queries[i]);
        }
        return anw;
    }


    public static String removeStars(String s) {
        StringBuilder resultBuilder = new StringBuilder();
        Stack<Character> stackString = new Stack<>();
        for(int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) != '*') {
                stackString.push(s.charAt(i));
            } else {
                if(!stackString.isEmpty()) {
                    stackString.pop();
                }
            }
        }

        while(!stackString.isEmpty()) {
            resultBuilder.append(stackString.pop());
        }
        return resultBuilder.reverse().toString();
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int result = 0;
        int pos_M = 0;
        int pos_G = 0;
        int pos_P = 0;
        for(int i = 0; i < garbage.length; i ++) {
            String temp = garbage[i];
            result += temp.length();
            if(temp.contains("M")) {
                pos_M = i;
            }
            if(temp.contains("G")) {
                pos_G = i;
            }
            if(temp.contains("P")) {
                pos_P = i;
            }
        }
        int sum = 0;
        int[] sumT = new int[travel.length];
        for(int i =0; i < travel.length; i ++) {
            sum += travel[i];
            sumT[i] = sum;
        }
        if(pos_M != 0) {
            result += (sumT[pos_M - 1] );
        }
        if(pos_P != 0) {
            result += sumT[pos_P - 1];
        }
        if(pos_G != 0) {
            result += sumT[pos_G - 1];
        }
        return result;
    }


//    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
//
//    }

    public static void main(String[] args) {
//        int[] test = {4,5,2,1};
//        int[] query = {10, 21};
//       int[] result = (answerQueries(test, query));
//       for(int r : result) {
//           System.out.println(r);
//       }
        System.out.println(removeStars("leet**cod*e"));
        System.out.println(removeStars("erase*****"));
    }
}
