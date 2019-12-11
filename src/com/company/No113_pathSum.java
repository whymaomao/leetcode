package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No113_pathSum {

    private void backtrace(TreeNode root, int sum, List<List<Integer>> result, List<Integer>temp)
    {
        if(root == null) return;
        temp.add(root.val);

        if(root.val == sum && root.left == null && root.right == null)
        {
            result.add(new LinkedList<>(temp));
        }else {
            backtrace(root.left, sum - root.val, result, temp);
            backtrace(root.right, sum - root.val, result, temp);
        }
        temp.remove(0);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;
        List<Integer> temp = new LinkedList<>();

        backtrace(root, sum, result, temp);
        return result;
    }
}
