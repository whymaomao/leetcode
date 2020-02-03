package com.company;

import java.util.ArrayList;
import java.util.List;

public class No1023_camelMatch {

    private Boolean camelMatchString(String query, String pattern){
        int patternIndex = 0;
        int queryIndex = 0;
        int patternLength = pattern.length();
        int queryLength = query.length();

        while(queryIndex < queryLength){

            if(patternIndex < patternLength){
                if(query.charAt(queryIndex) == pattern.charAt(patternIndex)){
                    queryIndex ++;
                    patternIndex ++;
                }else{
                    if(!(query.charAt(queryIndex) >= 'a' && query.charAt(queryIndex) <= 'z'))
                        return false;
                     else
                        queryIndex ++;
                }
            }else{
                if(!(query.charAt(queryIndex) >= 'a' && query.charAt(queryIndex) <= 'z'))
                    return false;
                else queryIndex ++;
            }
        }

        if(patternIndex == patternLength) return true;
        else return false;
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> resultMatch = new ArrayList<>();

        for(int i = 0; i < queries.length; i ++){
            resultMatch.add(camelMatchString(queries[i], pattern));
        }
        return resultMatch;
    }
}
