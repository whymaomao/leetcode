package com.company;

public class No121_maxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if(prices.length == 0) return maxProfit;
        int min = prices[0];
        for(int i = 1; i < prices.length; i ++)
        {
            if(prices[i] > prices[i - 1])
            {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }
            else
            {
                min = Math.min(min, prices[i]);
            }
        }

        return maxProfit;

    }
}
