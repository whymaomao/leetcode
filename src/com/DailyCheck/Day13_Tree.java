package com.DailyCheck;

import com.company.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Day13_Tree {

    private void inOrderTreeList(TreeNode treeNode, List<Integer> treeList) {
        if(treeNode == null) {
            return;
        }

        inOrderTreeList(treeNode.left, treeList);
        treeList.add(treeNode.val);
        inOrderTreeList(treeNode.right, treeList);
    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> treeList = new ArrayList<>();
        inOrderTreeList(root, treeList);

        int minDiff =Integer.MAX_VALUE;
        for(int i = 1; i < treeList.size(); i ++) {
            minDiff = Math.min(minDiff, treeList.get(i) - treeList.get(i - 1));
        }
        return minDiff;

    }
}
