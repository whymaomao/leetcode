package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No94_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        TreeNode tempRoot = root;

        while(tempRoot != null || !stack.isEmpty()){
            if(tempRoot != null)
            {
                stack.push(tempRoot);
                tempRoot = tempRoot.left;
            }else
            {
                result.add(stack.pop().val);
                tempRoot = tempRoot.right;
            }
        }
        return result;
    }
}
