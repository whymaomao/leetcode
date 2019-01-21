package com.company;

import java.util.HashSet;
import java.util.Set;

public class No771_numJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> Jewles = new HashSet<Character>();
        for(int i = 0; i < J.length(); i ++)
        {
            Jewles.add(J.charAt(i));
        }
        int count = 0;
        for(int k = 0; k < S.length(); k ++)
        {
            if(Jewles.contains(S.charAt(k)))
                count ++;
        }
        return count;
    }
}
