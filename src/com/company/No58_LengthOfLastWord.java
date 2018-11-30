package com.company;

public class No58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s == null) return 0;
        String[] words = s.split(" ");
        for(int i = words.length - 1; i >= 0; i --)
        {
            if(words[i] != " ")
            {
                return words[i].length();
            }
        }
        return 0;

    }
}
