package com.company;

import java.util.List;

public class No6_ZigZag {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int len = s.length();
        int gap = numRows * 2 - 2;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < len; j += gap) {
                temp.append(s.charAt(j));
                if (i > 0 && i < numRows - 1) {
                    int tempAdd = j + gap - i * 2;
                    if (tempAdd < len) temp.append(s.charAt(tempAdd));
                }
            }
        }
        return temp.toString();
    }

    void modifyList(List<Integer> list)
    {
        int len = list.size();
        list.clear();
        for(int i= 0; i < len; i ++)
        {
            list.add(1);
        }

    }

}
