package com.company;

public class No806_numberOfLines {
    public int[] numberOfLines(int[] widths, String S) {
        int[] result = new int[2];
        int LengthSum = 0;
        int end = S.length();
        int count = 1;
        for(int i = 0; i < end; i ++)
        {
            int temp =  widths[S.charAt(i) - 'a'];
            LengthSum += temp;
            if(LengthSum > 100)
            {
                count = count + 1;
                LengthSum = temp;
            }
        }
        result[0] = count;
        result[1] = LengthSum;
        return result;


    }
}
