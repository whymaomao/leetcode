package com.DailyCheck;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Day3_No2418_sortPeople {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> peopleMap = new HashMap<>();
        for(int i = 0; i < heights.length; i ++) {
            peopleMap.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        int n = heights.length;
        for(int i = 0; i < heights.length; i ++) {
            names[i] = peopleMap.get(heights[n - i - 1]);
        }
        return names;
    }

    public int longestSubarray(int[] nums) {
        int maxResult = 0;
        int lenResult = 1;
        for(int num : nums) {
            if(num > maxResult) {
                maxResult = num;
            }
        }
        for(int i = 1; i < nums.length; i ++) {
            int temp = nums[i] & nums[i-1];
            if(temp > maxResult) {
                maxResult = temp;
                lenResult = 2;
            }
        }
        return lenResult;
    }

    public int getKthMagicNumber(int k) {
        int []dp = new int[k + 1];
        dp[1] = 1;
        int num3 = 1, num5 = 1, num7 = 1;
        for(int i = 2; i < k + 1; i ++) {
            int nextNum3 = dp[num3] * 3, nextNum5 = dp[num5] * 5, nextNum7 = dp[num7]*7;
            int nextNum = Math.min(Math.min(nextNum3, nextNum5), nextNum7);
            if(nextNum == nextNum3) {
                num3 ++;
            }
            if(nextNum == nextNum5) {
                num3 ++;
            }
            if(nextNum == nextNum7) {
                num3 ++;
            }
            dp[i] = nextNum;
        }
        return dp[k];
    }

    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        String tempS = s2 + s2;
        return tempS.contains(s1);
    }

    public static boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> permutationMap = new HashMap<>();
        for(int i = 0; i < s1.length(); i ++) {
            Character temp = s1.charAt(i);
            permutationMap.put(temp, permutationMap.getOrDefault(temp, 0) + 1) ;
        }
        for(int i = 0; i < s2.length(); i ++) {
            Character temp = s2.charAt(i);
            if(!permutationMap.containsKey(temp)) {
                return false;
            } else {
                permutationMap.put(temp, permutationMap.get(temp) - 1);
            }
        }
        return permutationMap.values().stream().allMatch(value -> value == 0);
    }

    public boolean isUnique(String astr) {
        char[] astrArr = astr.toCharArray();
        Arrays.sort(astrArr);
        for(int i = 1; i < astrArr.length; i ++ ) {
            if(astrArr[i] == astrArr[i-1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * There are three types of edits that can be performed on strings: insert a character,
     * remove a character, or replace a character. Given two strings, write a function
     * to check if they are one edit (or zero edits) away.
     */
    public static boolean oneEditAway(String first, String second) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(oneEditAway("pales", "pal"));
    }
}
