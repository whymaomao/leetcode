package com.company;

import java.util.HashMap;
import java.util.Map;

public class contest1_changeString {

    public int minimumSwap(String s1, String s2) {

        // length different return -1
        if(s1.length() != s2.length()) return -1;

        // check whether the x or y in the string is odd
        int xySwapNum = 0;
        int yxSwapNum = 0;

        for(int i = 0; i < s1.length(); i ++)
        {
            if(s1.charAt(i) != s2.charAt(i)) {
                String tempDiff = String.valueOf(s1.charAt(i)) + String.valueOf(s2.charAt(i));
                if(tempDiff.equals("xy")) xySwapNum ++;
                if(tempDiff.equals("yx")) yxSwapNum ++;
             }
        }

        // check xy and yx, return the swap numbers
        int XYLeft = xySwapNum %2 ;
        int YXLeft = yxSwapNum %2 ;

        if(XYLeft != YXLeft) return -1;
        else if(XYLeft == 0)
            return xySwapNum /2 + yxSwapNum /2;
        else return xySwapNum /2 + yxSwapNum /2 + 2;
    }
}