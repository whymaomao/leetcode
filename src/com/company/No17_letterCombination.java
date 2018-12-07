package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No17_letterCombination {
    private List<StringBuilder> getCombinations(List<StringBuilder> input, String letter)
    {
        if(letter == null) return input;
        if(input.size() == 0)
        {
            for(int i = 0; i < letter.length(); i ++)
            {
                input.add(new StringBuilder().append(letter.charAt(i)));
            }
            return input;
        }
        else {
            List<StringBuilder> result = new ArrayList<StringBuilder>();
            for (int i = 0; i < input.size(); i++) {
                StringBuilder cur = input.get(i);
                for (int j = 0; j < letter.length(); j++) {
                    result.add(new StringBuilder().append(cur.toString()+ letter.charAt(j)));
                }
            }
            return result;
        }
    }

    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> letterMap = new HashMap<Character, String>();
        letterMap.put('1',"");
        letterMap.put('2',"abc");
        letterMap.put('3',"def");
        letterMap.put('4',"ghi");
        letterMap.put('5',"jkl");
        letterMap.put('6',"mno");
        letterMap.put('7',"pqrs");
        letterMap.put('8',"tuv");
        letterMap.put('9',"wxyz");

        if(digits == null) return null;
        List<StringBuilder> result = new ArrayList<StringBuilder>();

        for(int i = 0; i < digits.length(); i ++)
        {
            String letter = letterMap.get(digits.charAt(i));
            result = getCombinations(result,letter);
        }

        List<String> ret = new ArrayList<String>();
        for(int i = 0; i < result.size(); i ++)
        {
            ret.add(result.get(i).toString());
        }
        return ret;
    }
}
