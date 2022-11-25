package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Stream;

public class No2100_goodDays {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> goodDaysList = new ArrayList<>();

        int length = security.length;
        int start = time;
        int end = length - time;

        int[] leftArray = new int[length];
        int[] rightArray = new int[length];

        for(int i = 1; i < length; i ++) {
            if(security[i] <= security[i-1]) {
                leftArray[i] = leftArray[i-1] + 1;
            } else{
                leftArray[i] = 0;
            }
        }

        for(int j = length - 2; j >= 0; j --) {
            if(security[j] <= security[j + 1]) {
                rightArray[j] = rightArray[j + 1] + 1;
            } else {
                rightArray[j] = 0;
            }
        }

        for(int i = start; i < end; i ++) {
            if(leftArray[i] >= time && rightArray[i] >= time) {
                goodDaysList.add(i);
            }
        }
        return goodDaysList;
    }


    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        Map<Integer, Integer> arrayMap = new HashMap<>();
        for (int num : changed) {
            arrayMap.put(num, arrayMap.containsKey(num) ? 1 : arrayMap.get(num) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int num : changed) {
            if (arrayMap.get(num) != 0) {
                arrayMap.put(num, arrayMap.get(num) - 1);
                int doubleNum = num * 2;
                if (arrayMap.get(doubleNum) != 0) {
                    result.add(num);
                    arrayMap.put(doubleNum, arrayMap.get(doubleNum) - 1);
                }
            }
        }

        for (int num : changed) {
            if (arrayMap.get(num) != 0) {
                return new int[]{};
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    private int findLastLocation(List<Integer> helperList, int target) {
        int start = 0;
        int end = helperList.size() - 1;

        while ( start <= end) {
            int min = (end - start) / 2 + start;
            if(target < helperList.get(min)) {
                end = min - 1;
            } else if (target > helperList.get(min) ) {
                start = min + 1;
            } else return min;
        }
        return start;
    }



    public long maxTaxiEarnings(int n, int[][] rides) {
        int size = rides.length;
        List<Integer> helperList = new ArrayList<>();
        helperList.add(Integer.MIN_VALUE);
        long[] dp = new long[size + 1];

        for(int i = 1; i < size + 1; i ++) {
            if(rides[i -1][1] > helperList.get(i)) {
                dp[i] = dp[i - 1] + (rides[i-1][1] - rides[i-1][0] + rides[i-1][2]);
                helperList.add(rides[i-1][1]);
            } else {
                int index = findLastLocation(helperList, rides[i -1][1]);
                dp[i] = dp[index] + (rides[i-1][1] - rides[i-1][0] + rides[i-1][2]);
                if(dp[i] > dp[i-1]) {
                    helperList.add(rides[i-1][1]);
                } else {
                    helperList.add(helperList.get(i-1));
                    dp[i] = dp[i-1];
                }
            }
        }
        return dp[size];
    }

    public static void main(String[] args) {
        List<String> testString = new ArrayList<>();
        List<String> actualString = new ArrayList<>();

        testString.add("test");
        actualString.add("actual");


    }

}
