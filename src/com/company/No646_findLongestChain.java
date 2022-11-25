package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class No646_findLongestChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (pair1, pair2) -> {
            if(pair1[0] == pair2[0]) {
                return pair1[1] - pair2[1];
            } else {
                return pair1[0] - pair2[0];
            }
        });

        int result = 1;
        int right = 0;
        for(int i = 0; i < pairs.length; i ++) {
            if(i == 0) {
                right = pairs[0][1];
                result ++;
            }else {
                if(pairs[i][0] > right && pairs[i][1] > right) {
                    result ++;
                    right = pairs[i][1];
                }
            }
        }
        return result;
    }
}
