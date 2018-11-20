package com.company;

import java.util.HashMap;
import java.util.Map;

/*
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
 */
public class No13_romanToInt {
    public int romanToInt(String s) {
        Map<Character,Integer> hashMap = new HashMap<Character,Integer>();

        hashMap.put('I',1);
        hashMap.put('V',5);
        hashMap.put('X',10);
        hashMap.put('L',50);
        hashMap.put('C',100);
        hashMap.put('D',500);
        hashMap.put('M',1000);


        int result = 0;
        for(int i = 0; i < s.length(); i ++)
        {
            if( (i > 0) &&
                    (hashMap.get(s.charAt(i-1)) < hashMap.get(s.charAt(i))))
            {
                result -= (2*hashMap.get(s.charAt(i -1)));
            }
            result += hashMap.get(s.charAt(i));

        }
        return result;
    }
}
