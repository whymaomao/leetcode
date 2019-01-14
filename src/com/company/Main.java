package com.company;
import java.util.*;
import java.util.stream.Collectors;

public class Main{

    public static void main(String[] args) {

        No49_groupAnagrams solution = new No49_groupAnagrams();
        String[] test ={"huh","tit"};
        List<List<String>> result = solution.groupAnagrams(test);
        for(int i = 0; i < result.size(); i ++)
        {
            System.out.println(result.get(i));
        }
    }


}
