package com.company;

public class No775_isIdealPermutation {
    public boolean isIdealPermutation(int[] nums) {
//        int allPermutation = 0;
//        int subPermutation = 0;
//        for(int i = 0; i < nums.length - 1; i ++) {
//            if(nums[i+1] < nums[i]) {
//                subPermutation ++;
//            }
//        }
        for(int i = 0; i < nums.length; i ++) {
            for(int j = i + 2; j < nums.length; j ++) {
                if(nums[j] < nums[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
