package com.DailyCheck;

import java.util.ArrayList;
import java.util.List;

public class Day9_StockSpanner {

    List<Integer> stockList = new ArrayList<>();


    public Day9_StockSpanner() {

    }

    public int next(int price) {
        stockList.add(price);
        int result = 0;
        int stockLen = stockList.size();
        for(int i = stockLen - 1; i >= 0; i --) {
            if(price >= stockList.get(i)) {
                result ++;
            } else {
                break;
            }
        }
        return result;
    }
}
