package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No199_rightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new LinkedList<>();

        if(root == null) return null;
        TreeNode tempNode = root;
        queue.add(tempNode);
        queue.add(null);
        int tempValue = tempNode.val;

        while(!(queue.size() == 1 && queue.peek() == null)){
          tempNode = queue.poll();
           if(tempNode != null)
           {
               if(tempNode.left != null)
                   queue.add(tempNode.left);
               if(tempNode.right != null)
                   queue.add(tempNode.right);
               tempValue = tempNode.val;
           }else
           {
               queue.add(null);
               result.add(tempValue);
           }

        }

        result.add(tempValue);
        return result;
    }
}
