package com.company;

import java.util.Arrays;

public class No169_majorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return(nums[nums.length/2]);

    }
}
