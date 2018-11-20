package com.company;

import java.util.ArrayList;
import java.util.List;

public class No7_ReverseInterger {
    public int reverse(int x) {
        List<Integer> bitInterger = new ArrayList<Integer>();
        int IsMinus = (x > 0? 1: -1);
        int temp = IsMinus> 0? x: -x;
        while(temp > 0) {
            int bit = temp % 10;
            bitInterger.add(bit);
            temp = temp / 10;
        }
        long result = 0;
        for(int i: bitInterger)
        {
            result = (result*10 + i);
        }
        if(IsMinus*result > Integer.MAX_VALUE) return 0;
        if(IsMinus*result < Integer.MIN_VALUE) return 0;
        return IsMinus*(int)result;

    }
}
