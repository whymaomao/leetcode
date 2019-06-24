package com.company;

public class No905_sortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int end = A.length - 1;
        int start = 0;
        while(start < end)
        {
            if(A[start] %2 == 1 && A[end] %2 == 0)
            {
                int temp = A[start];
                A[start] = A[end];
                A[end] = temp;
                start ++;
                end --;
                continue;

            }
            if(A[start] %2 == 0)
                start ++;
            if(A[end] %2 == 1)
                end --;
        }
        return A;

    }
}
