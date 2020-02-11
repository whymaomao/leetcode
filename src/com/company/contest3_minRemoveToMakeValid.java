package com.company;

import java.util.Stack;

public class contest3_minRemoveToMakeValid {

    private String stackToString(Stack<Character> validString)
    {
        StringBuffer stringBuffer = new StringBuffer();
        while(!validString.isEmpty()){
            char temp = validString.peek();
            if(temp == '(') break;
            stringBuffer.append(validString.pop());
        }
        return stringBuffer.toString();
    }

    public String minRemoveToMakeValid(String s) {
        int start = 0;
        Stack<Character> validString = new Stack<>();
        String returnString = "";

        for(int i = 0; i < s.length(); i ++)
        {
            if(s.charAt(i) != '(' && s.charAt(i) != ')')
            {
                validString.push(s.charAt(i));
            }
            if(start == 0 && s.charAt(i) == ')')
                continue;
            if(s.charAt(i) == '(')
            {
                validString.push(s.charAt(i));
                start ++;
            }
            if(s.charAt(i) == ')'){
                validString.push(s.charAt(i));
                start --;
                returnString += stackToString(validString);
            }
        }

        if(!validString.isEmpty()){
            returnString += stackToString(validString);
            returnString += ')';

        }
        return returnString;
    }
}
