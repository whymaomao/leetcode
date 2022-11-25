package com.DailyCheck;

import com.yue.ListNode;

import java.util.*;

public class Day5_No817_numComponents {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> numsSet = new HashSet<Integer>();
        for(int num : nums) {
            numsSet.add(num);
        }

        ListNode tempHead = head;
        boolean isComponent = false;
        int result = 0;
        while(tempHead != null) {
            if(numsSet.contains(tempHead.val)) {
                isComponent = true;
            } else {
                if(isComponent) {
                    result ++;
                    isComponent = false;
                }
            }
            tempHead = tempHead.next;
        }
        if(isComponent) result ++;
        return result;
    }


    public boolean equalFrequency(String word) {
//        Map<Character, Integer> wordFreq = new HashMap<>();
//        for(int i = 0; i < word.length(); i ++) {
//            wordFreq.put(word.charAt(i), wordFreq.getOrDefault(word.charAt(i), 0 ) + 1);
//        }
//        int currentVal = 0;
//        int freqNum = 0;
//        for(Integer num : wordFreq.values()) {
//            if(num != currentVal ) {
//                if(freqNum )
//            }
//        }
        return false;

    }

    /**
     * Deque<Integer> stk = new ArrayDeque<>();
     *         for (int v : arr) {
     *             if (stk.isEmpty() || v >= stk.peek()) {
     *                 stk.push(v);
     *             } else {
     *                 int mx = stk.pop();
     *                 while (!stk.isEmpty() && stk.peek() > v) {
     *                     stk.pop();
     *                 }
     *                 stk.push(mx);
     *             }
     *         }
     *         return stk.size();
     */
    public int maxChunksToSorted(int[] arr) {
       Deque<Integer> stack = new ArrayDeque<>();
       for(int v : arr) {
           if(stack.isEmpty() || v > stack.peek()) {
               stack.push(v);
           } else {
               int currentMax = stack.pop();
               while(!stack.isEmpty() && v < stack.peek()) {
                   stack.pop();
               }
               stack.push(currentMax);
           }
       }
       return stack.size();
    }
}
