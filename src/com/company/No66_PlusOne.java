package com.company;

public class No66_PlusOne {
    public int[]plusOne(int[] digits)
    {
        if(digits.length == 0) return null;
        int temp = 1;

        for(int i = digits.length - 1; i >= 0; i --)
        {
            digits[i] += temp;
            if(digits[i] > 9)
            {
                digits[i] -= 10;
                temp = 1;
            }
            else temp = 0;
        }

        if(temp == 1)
        {
            int []res = new int[digits.length + 1];
            res[0] = 1;
            for(int i = 0; i < digits.length; i ++)
            {
                res[i+1] = digits[i];
            }
            return res;
        }
        return digits;
    }
}
