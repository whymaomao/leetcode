package com.company;

import java.util.Stack;

public class No1021_removeOuterParentheses {

    public String removeOuterParentheses(String S) {
        //check S can be removed outer parentheses
        // Use stack

        Stack<Character> stack = new Stack<>();
        String result = "";
        for(int i = 0; i < S.length(); i ++)
        {
            if(stack.isEmpty() && S.charAt(i) == '(')
            {
                stack.push('(');
                continue;
            }
            if(stack.size() == 1 && S.charAt(i) == ')')
            {
                stack.pop();
                continue;
            }
            if(S.charAt(i) == '(')
            {
                stack.push(S.charAt(i));
            }
            if(S.charAt(i) == ')')
            {
                stack.pop();
            }
            result += S.charAt(i);
        }
        return result;


    }
}
