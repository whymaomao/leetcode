package com.company;

public class No14_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        boolean IsCommonPrefix = false;

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i ++)
        {
            for(int j = 1; j < strs.length; j ++)
            {
                if( (i) == strs[j].length()) {
                    IsCommonPrefix = true;
                    break;
                }
                if(strs[0].charAt(i) != strs[j].charAt(i))
                {
                    IsCommonPrefix = true;
                    break;
                }
            }

            if(IsCommonPrefix == true)
                break;
            else
                result.append(strs[0].charAt(i));

        }
        return result.toString();
    }
}
