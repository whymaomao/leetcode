package com.company;

import java.util.*;

public class No103_zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if(root == null) return result;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        TreeNode tempRoot = root;

        nodeQueue.add(tempRoot);
        nodeQueue.add(null);

        int level = 0;
        List<Integer> levelTree = new LinkedList<>();
        while(!(nodeQueue.isEmpty()))
        {
            tempRoot = nodeQueue.poll();
            if(tempRoot != null) {
                levelTree.add(tempRoot.val);
                if (tempRoot.left != null)
                    nodeQueue.add(tempRoot.left);
                if (tempRoot.right != null)
                    nodeQueue.add(tempRoot.right);
            }
            else
            {
                List<Integer> copyList = new LinkedList<>(levelTree);
                if(level%2 == 0)
                {
                    result.add(copyList);
                }else{
                    Collections.reverse(copyList);
                    result.add(copyList);
                }
                level ++;
                levelTree.clear();
                if(!nodeQueue.isEmpty())
                    nodeQueue.add(null);
            }
        }

        return result;
    }


    public static void main(String[] args)
    {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        No103_zigzagLevelOrder test = new No103_zigzagLevelOrder();
        test.zigzagLevelOrder(treeNode);
    }
}
