package com.company;


public class No29_divide {
    public static int divide(int dividend, int divisor) {

        boolean isNegative = ((dividend > 0) != (divisor > 0));

        long dividend_temp = Math.abs((long)dividend);
        long divisor_temp = Math.abs((long)divisor);

        long count = 0;
        long temp = divisor_temp;

        count = ldivide(dividend_temp, divisor_temp);

        if(isNegative)
        {
            if(-count < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            else return (int)(-count);
        }else
        {
            if(count > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else return (int)count;
        }
    }

    private static long ldivide(long ldividend, long ldivisor) {
        // Recursion exit condition
        if (ldividend < ldivisor) return 0;

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        long sum = ldivisor;
        long multiple = 1;
        while ((sum+sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor);
    }

    public static void main(String[] args)
    {
        System.out.println(No29_divide.divide(-15, -1));
    }
}
