package com.company;
/**
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32.
 * */


public class No938_rangeSumBST {

    private int sum = 0;
    private void traverseBST(TreeNode tree, int L, int R){
        if(tree == null) return;
        traverseBST(tree.left, L, R);
        if(tree.val >= L && tree.val <= R)
        {
            sum += tree.val;
        }
        traverseBST(tree.right,L, R);
    }

    public int rangeSumBST(TreeNode root, int L, int R) {

        if(root == null) return 0;
        traverseBST(root,L,R);
        return sum;
    }
}


