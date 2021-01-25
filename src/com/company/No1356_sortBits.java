package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class No1356_sortBits {



    private int getBits(int num){
        String bin = Integer.toBinaryString(num);
        int sum = 0;
        for(int i = 0; i < bin.length(); i ++){
            if(bin.charAt(i) == '1')
                   sum ++;
        }
        return sum;
    }

    public int[] sortByBits(int[] arr) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int num1 = getBits(o1);
                int num2 = getBits(o2);
                if ( num1 == num2 )return o1 - o2;
                else return num1 - num2;
            }
        };


        Integer[] temp=new Integer[arr.length];
        for(int i=0;i<arr.length;i++)
            temp[i]=arr[i];
        Arrays.sort(temp,comparator);
        for(int i=0;i<arr.length;i++)
            arr[i]=temp[i];
        return arr;

    }
}
