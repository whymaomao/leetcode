package com.company;

import java.util.HashMap;
import java.util.Stack;

public class No20_isValid {
        public boolean isValid(String s) {
            if(s == null ) return true;
            Stack<Character> util = new Stack<Character>();
            HashMap<Character,Character>Parantheses = new HashMap<Character, Character>();
            Parantheses.put(')','(');
            Parantheses.put(']','[');
            Parantheses.put('}','{');

            for(int i = 0; i < s.length(); i ++)
            {
                if(util.isEmpty()) return false;
                if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' )
                    util.push(s.charAt(i));
                else if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')
                {
                    if(Parantheses.get(s.charAt(i)) == util.peek())
                    {
                        util.pop();
                    }
                    else
                    {
                        return false;
                    }
                }
            }
            return util.isEmpty();
        }
}
