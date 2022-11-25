package com.DailyCheck;

public class Day4_interview03_replaceSpaces {
    public static boolean areAlmostEqual(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 != len2) {
            return false;
        }

        char s1_c1 = 0, s1_c2 = 0;
        char s2_c1 = 0, s2_c2 = 0;
        int diff = 0;

        for(int i = 0; i < len1; i ++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                diff ++;
                if( diff == 1) {
                    s1_c1 = s1.charAt(i);
                    s2_c1 = s2.charAt(i);
                } else if (diff == 2) {
                    s1_c2 = s1.charAt(i);
                    s2_c2 = s2.charAt(i);
                } else {
                    return false;
                }
            }
        }

        if(diff == 0 || ( diff == 2 && (s1_c1 == s2_c2 && s1_c2 == s2_c1)) ) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(areAlmostEqual("bank", "kanb"));
    }
}
