package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No49_groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
           step1: transfer the item in strs("hit") to "h1i1t1"
           step2: create a HashMap and use the above item as key
           step3: transfer the list in HashMap to List<List<String>>
         */
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> tempMap = new HashMap<>();

        for(int i = 0; i < strs.length; i ++)
        {
            String strSum = new String();
            int[] groupTemp = new int[26];
            for(int j = 0; j < strs[i].length(); j ++)
            {
                groupTemp[(strs[i].charAt(j) - 'a')] ++;
            }
            for(int k = 0; k < 26; k ++)
            {
                if(groupTemp[k] != 0)
                {
                    strSum += (char)('a' + k);
                    strSum += (char)('0' + groupTemp[k]);
                }
            }
            if(tempMap.containsKey(strSum))
                tempMap.get(strSum).add(strs[i]);
            else
            {
                List<String> strList = new ArrayList<String>();
                strList.add(strs[i]);
                tempMap.put(strSum,strList);
            }
        }

        for(Map.Entry<String,List<String>>entry: tempMap.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
}
