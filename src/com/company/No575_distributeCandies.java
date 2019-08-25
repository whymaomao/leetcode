package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No575_distributeCandies {
    public int distributeCandies(int[] candies) {
        int result = 1;

        Arrays.sort(candies);
        int maxDistribute = candies.length / 2;
        for(int i = 1; i < candies.length; i ++)
        {
            if(candies[i] != candies[i - 1])
            {
                result ++;
            }
        }
        return (result > maxDistribute)? maxDistribute: result ;
    }
}
