package com.company;

public class No1310_xorQueries {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int length = arr.length;
        int[] xorArray = new int[length + 1];
        xorArray[0] = 0;

        for(int i = 1; i < length + 1; i ++){
            xorArray[i] = xorArray[i-1] ^ arr[i-1];
        }

        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i ++){
            result[i] = xorArray[queries[i][1] + 1] ^ xorArray[queries[i][0]];
        }
        return result;
    }
}
