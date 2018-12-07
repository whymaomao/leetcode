package com.company;

import java.util.ArrayList;

public class No9_PalindromeNUm {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int temp = x;
        while(temp > 0)
        {
            arrayList.add(temp%10);
            temp /= 10;
        }
        int end = arrayList.size() - 1;
        for(int i = 0; i < arrayList.size()/2; i ++)
        {
            if(arrayList.get(i) != arrayList.get(end))
                return false;
            else
            {
                end --;
            }

        }
        return true;

    }
}
