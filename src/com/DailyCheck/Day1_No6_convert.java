package com.DailyCheck;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Day1_No6_convert {
    public static String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
       int pack = 2 * numRows  - 2;
       int len = s.length();

       StringBuilder resultBuilder = new StringBuilder();
       // start // mid // end
        int index = 0;
        while(index < len) {
            resultBuilder.append(s.charAt(index));
            index += pack;
        }

        for(index = 1; index < len && index < numRows - 1 ; index ++) {
            int tempMidIndex = index ;
            int i = 1;
            while ( tempMidIndex < len) {
                resultBuilder.append(s.charAt(tempMidIndex));
                int temp = i * pack - index ;
                if (temp < len) {
                    resultBuilder.append(s.charAt(temp));
                }
                tempMidIndex += pack;
                i ++;
            }
        }

        index = numRows - 1;
        while(index < len) {
            resultBuilder.append(s.charAt(index));
            index += pack;
        }

        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert( "PAYPALISHIRING", 4));
        System.out.println(convert("ABC", 2));
    }
}
