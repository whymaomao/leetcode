package com.company;

public class No844_backspaceCompare {
    public static boolean backspaceCompare(String S, String T) {
        StringBuilder backspaceS = new StringBuilder();
        StringBuilder backspaceT = new StringBuilder();

        for(int i = 0; i < S.length(); i ++)
        {
           if(S.charAt(i) == '#'){
               if(backspaceS.length() > 0) {
                   backspaceS.deleteCharAt(backspaceS.length() - 1);
               }
           }else{
               backspaceS.append(S.charAt(i));
           }
        }

        for(int j = 0; j < T.length(); j ++)
        {
            if(T.charAt(j) == '#'){
                if(backspaceT.length() > 0) {
                    backspaceT.deleteCharAt(backspaceT.length() - 1);
                }
            }else{
                backspaceT.append(T.charAt(j));
            }
        }
        System.out.println(backspaceS);
        System.out.println(backspaceT);
        return backspaceS.toString().equals(backspaceT.toString());
    }

    public static void main(String[] args)
    {
        System.out.println(backspaceCompare("ab#c","ad#c"));
    }
}
