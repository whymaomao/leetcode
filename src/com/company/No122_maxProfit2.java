package com.company;

public class No122_maxProfit2 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if(prices.length == 0) return maxProfit;
        int minP = prices[0];
        for(int i = 1; i < prices.length; i ++){
            if(prices[i] > prices[i -1])
                maxProfit += (prices[i] - prices[i -1]);
        }
        return maxProfit;
    }
}
