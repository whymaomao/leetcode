package com.company;

public class No104_maxDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int nLeft = maxDepth(root.left);
        int rLeft = maxDepth(root.right);

        return (nLeft > rLeft)? (nLeft + 1):(rLeft + 1);

    }
}
