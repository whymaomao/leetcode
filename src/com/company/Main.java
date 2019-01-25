package com.company;
import java.util.*;
import java.util.stream.Collectors;

public class Main{

    public static void main(String[] args) {

        No929_numUniqueEmails solution = new No929_numUniqueEmails();
        String[] test = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(solution.numUniqueEmails(test));
    }


}
