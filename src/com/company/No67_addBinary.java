package com.company;

public class No67_addBinary {
    public String addBinary(String a, String b) {
        if(a == null || b == null) return null;
        StringBuilder result = new StringBuilder();

        int a_len = a.length() - 1; int b_len = b.length() - 1;
        int carry = 0;

        while(a_len >= 0 || b_len >= 0)
        {
            int sum = carry;
            if(a_len >= 0){
                sum += (a.charAt(a_len) - '0');
                a_len --;
            }
            if(b_len >= 0){
                sum += (b.charAt(b_len) - '0');
                b_len --;
            }
            result.append((sum%2));
            carry = sum/2;
        }
        if(carry != 0) result.append('1');
        return result.reverse().toString();
    }
}
