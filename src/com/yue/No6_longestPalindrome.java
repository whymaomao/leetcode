package com.yue;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class No6_longestPalindrome {
    public static String longestPalindrome(String s) {
        int len = s.length();
        int longestResult = 1;
        String result = new String("");
        for(int i = 0; i < len; i ++) {
            int leftIndex = i - 1;
            int rightIndex = i + 1;
            while(leftIndex >= 0 && rightIndex < len && s.charAt(leftIndex) == s.charAt(rightIndex) ) {
                leftIndex -- ;
                rightIndex ++;
            }
            int tempLen = rightIndex - leftIndex - 1;
            if(tempLen >= longestResult) {
                result = s.substring(leftIndex + 1, rightIndex );
                longestResult = result.length();
            }
        }

        System.out.println(longestResult);

        int tempLen = 1;
        char tempChar = s.charAt(0);
        int leftIndex = 0;
        int rightIndex = leftIndex;
        for(int i = 1; i < len; i ++) {
            if(s.charAt(i) == tempChar) {
                tempLen ++;
                rightIndex ++;
            } else {
                tempChar = s.charAt(i);
                if(tempLen > longestResult) {
                    result = s.substring(leftIndex, rightIndex + 1);
                    longestResult = tempLen;
                }
                tempLen = 1;
                leftIndex = i;
                rightIndex = leftIndex;
            }
        }

        if(tempLen > longestResult) {
            result = s.substring(leftIndex, rightIndex + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("tattarrattat"));
        System.out.println(longestPalindrome("cbbd"));
    }

}
