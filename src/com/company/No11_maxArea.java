package com.company;

public class No11_maxArea {
    public int maxArea(int[] height) {
        if (height.length <= 1) return 0;
        int MaxArea = 0;
        int TempArea = 0;

        int start = 0;
        int end = height.length - 1;

        while(start < end)
        {
            TempArea = (end - start)*(height[end] > height[start]? height[start]:height[end]);
            MaxArea = (MaxArea > TempArea)?MaxArea:TempArea;
            if(height[end] > height[start])
                start ++;
            else end --;
        }
        return MaxArea;
    }
}
