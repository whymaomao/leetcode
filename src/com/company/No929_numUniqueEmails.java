package com.company;

import java.util.HashSet;
import java.util.Set;

public class No929_numUniqueEmails {

    private String parseEmail(String email)
    {
        // remove . before @
        // cut string after +
        if (email == null) return null;
        int indexOfAt = email.indexOf('@');

        if(indexOfAt != -1)
        {
            String suffix = email.substring(indexOfAt + 1);
            email = email.substring(0,indexOfAt);

            int indexPlus = email.indexOf('+');
            if(indexPlus != -1)
                email = email.substring(0, indexPlus);
            while(true) {
               int indexDot = email.indexOf('.');
               if(indexDot == -1) break;
               else email = email.substring(0,indexDot) + email.substring(indexDot + 1);
            }
            email += suffix;
        }
        return email;
    }

    public int numUniqueEmails(String[] emails) {
        /*
        Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
        Output: 2
        Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
         */
        Set<String> EmailSet = new HashSet<String>();
        for(int i = 0; i < emails.length; i ++) {
            String emailTemp = parseEmail(emails[i]);
            EmailSet.add(emailTemp);
        }
        return EmailSet.size();
    }
}
