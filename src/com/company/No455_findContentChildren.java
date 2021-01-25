package com.company;

import java.util.Arrays;

public class No455_findContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int g_index = 0;
        int s_index = 0;
        int ret = 0;

        while(g_index < g.length && s_index < s.length)
        {
            if(g[g_index] <= s[s_index])
            {
                  ret ++;
                  g_index ++;
                  s_index ++;
            }else
            {
                  s_index ++;
            }
        }
        return ret;
    }
}
