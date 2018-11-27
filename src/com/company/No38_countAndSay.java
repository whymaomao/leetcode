package com.company;

public class No38_countAndSay {
    public String countAndSay(int n) {
        if(n < 1) return null;
        String startString = "1";
        if(n == 1) return startString;

        for(int i = 0; i < n - 1; i ++)
        {
            StringBuilder tempString = new StringBuilder();
            int charCount = 1;
            for(int j = 1; j < startString.length(); j ++)
            {

                if(startString.charAt(j) == startString.charAt(j-1))
                {
                    charCount ++;
                }
                else
                {
                    tempString.append(charCount);
                    tempString.append(startString.charAt(j-1));
                    charCount = 1;
                }
            }
            tempString.append(String.valueOf(charCount));
            tempString.append(startString.charAt(startString.length()-1));
            startString = tempString.toString();
        }
        return startString;
    }
}
