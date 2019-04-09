package com.company;

import java.util.Arrays;

public class No654_constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode result = new TreeNode(0);
        if(nums.length == 0) return null;
        int maxTemp = Arrays.stream(nums).max().getAsInt();


        return result;
    }
}
