package com.company;

public class No977_sortedSquares {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] result = new int[len];
        int MinusIndex = 0;
        for(;MinusIndex < len; MinusIndex ++)
        {
            if(A[MinusIndex] >= 0)
                break;
        }
        int MaxIndex = MinusIndex;
        MinusIndex -= 1;
        int index = 0;
        while(MinusIndex >= 0 && MaxIndex < len)
        {
           if((-A[MinusIndex]) < A[MaxIndex])
           {
               result[index] = A[MinusIndex] * A[MinusIndex];
               MinusIndex --;
           }
           else
           {
               result[index] = A[MaxIndex] * A[MaxIndex];
               MaxIndex ++;
           }
           index ++;
        }
        while(MinusIndex >= 0)
        {
            result[index] = A[MinusIndex] * A[MinusIndex];
            MinusIndex --;
            index ++;
        }
        while(MaxIndex < len)
        {
            result[index] = A[MaxIndex] * A[MaxIndex];
            MaxIndex ++;
            index ++;
        }
        return result;
    }
}
