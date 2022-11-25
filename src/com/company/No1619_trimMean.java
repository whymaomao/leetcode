package com.company;

import apple.laf.JRSUIUtils;
import com.yue.TriePractice;

import java.util.*;

public class No1619_trimMean {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int percent_num_5 = (int) (len * 0.05);
        double sum = 0;
        for(int i = percent_num_5; i < len - percent_num_5; i ++) {
            sum += arr[i];
        }
        return sum / len - 2*percent_num_5;
    }

    public int flipLights(int n, int presses) {

        return 0;
    }

    /**
     *
     * @param s
     * @return
     */
    public static int longestContinuousSubstring(String s) {
        int conLen = 1;
        int result = 0;
        int startIndex = 0;
        int endIndex = startIndex + 1;
        int stringLen = s.length();
        while(startIndex < stringLen && endIndex < stringLen) {
            if(s.charAt(endIndex) - s.charAt(endIndex - 1) == 1) {
                conLen ++;
                endIndex ++;
            } else {
                startIndex = endIndex;
                endIndex += 1;
                result = Math.max(conLen, result);
                conLen = 1;
            }
        }
        return Math.max(conLen, result);
    }


    /**
     * No 6182
     * @param root
     * @return
     */
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> levelQueue = new LinkedList<>();
        TreeNode result = root;
        if(root != null) {
            levelQueue.offer(root);
        }
        int level = 0;
        while(!levelQueue.isEmpty()) {
            int len = levelQueue.size();
            level ++;
            Queue<TreeNode> oddLevelQueue = new LinkedList<>();
            List<Integer> levelValue = new ArrayList<>();
            for(int i = 0; i < len; i ++ ) {
                TreeNode temp = levelQueue.poll();
                if(temp.left != null) {
                    levelQueue.offer(temp.left);
                    levelValue.add(temp.left.val);
                }
                if(temp.right != null) {
                    levelQueue.offer(temp.right);
                    levelValue.add(temp.right.val);
                }
                if((level & 1) != 0) {
                    oddLevelQueue.offer(temp);
                }
            }
            // reverse
            if((level & 1) != 0 && !levelValue.isEmpty()) {
                Collections.reverse(levelValue);
                int j = 0;
                for(int i = 0; i < len; i ++ ) {
                    TreeNode temp = oddLevelQueue.poll();
                    temp.left.val = levelValue.get(j);
                    j ++;
                    temp.right.val = levelValue.get(j);
                    j ++;
                }
            }
        }
        return result;
    }


    class TrieNode {
        int sum = 0;
        TrieNode[] children = new TrieNode[26];
        char data;
        TrieNode(char data) {
            this.data = data;
        }
    }


    public int[] sumPrefixScores(String[] words) {
        int[] prefixSum = new int[words.length];
        TrieNode p = new TrieNode('/');
        TrieNode root = p;
        for(String word: words) {
            p = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (p.children[index] == null) {
                    TrieNode child = new TrieNode(word.charAt(i));
                    p.children[index] = child;
                }
                p = p.children[index];
                p.sum ++;
            }
        }


       for(int i = 0; i < words.length; i ++) {
           int result = 0;
           p = root;
           String word = words[i];
           for(int j = 0; j < word.length(); j ++) {
               int index = word.charAt(j) - 'a';
               if(p.children[index] !=  null) {
                   p = p.children[index];
                   result += p.sum;
               }
           }
           prefixSum[i] = result;
       }
       return prefixSum;

    }


    public static void main(String[] args) {
        System.out.println(longestContinuousSubstring("abcde"));
    }

}
