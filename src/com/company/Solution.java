package com.company;

import java.util.*;

public class Solution {
    /*
     * @param str: A string
     * @return: a boolean
     */
    final static int MAX_CHAR = 256;

    public boolean isUnique(String str) {
        // write your code here
        if(str == null) return false;
        if(str.length() > 256) return false;
        int[] strNum = new int[MAX_CHAR];
        for(int i = 0; i < str.length(); i ++)
        {
            int index = str.charAt(i);
            strNum[index] ++;
            if(strNum[index] > 1) return false;
        }
        return true;
    }

    /**
     * @param nums: A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public int median(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        if(nums.length == 1)
            return nums[0];

        int n = nums.length;
        return quickSelect(nums,0,n-1,(n-1)/2);
    }

    private int quickSelect(int[] nums, int start, int end, int target)
    {
        int index = partition(nums,start,end);
        if(index == target)
            return nums[index];
        else if(index < target)
            return quickSelect(nums,index+1,end,target);
        else
            return quickSelect(nums,start,index-1,target);
    }

    private int partition(int[] nums, int start, int end)
    {
        int pivot = end;
        int pivotValue = nums[pivot];

        while(start < end)
        {
            while(start < end && nums[start] < pivotValue)
                start ++;
            while(start < end && nums[end] >= pivotValue)
                end --;
            swap(nums, start, end);
        }
        swap(nums,start,pivot);
        return start;
    }

    private void swap(int[] nums, int start, int end)
    {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }


    public int[] twoSum(int[] nums, int target) {
        if(nums == null ) return null;
        int []result = new int[2];
        Map<Integer,Integer> numsMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i ++)
        {
            numsMap.put(nums[i],i);
        }
        for(int i = 0; i < nums.length; i ++)
        {
            int left = target - nums[i];
            if(numsMap.containsKey(left))
            {
                if(numsMap.get(left) != i)
                {
                    result[0] = i;
                    result[1] = numsMap.get(left);
                    break;
                }
            }
        }
        return result;
    }

    private class ListNode
    {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return null;
        ListNode result = new ListNode(0);
        ListNode ret = result;
        ListNode headL1 = l1;
        ListNode headL2 = l2;
        int addmore = 0;
        while(headL1 != null || headL2 != null)
        {
            result.val = headL1.val + headL2.val + addmore;
            if(result.val >= 10) addmore = result.val/10;
            headL1 = headL1.next;
            headL2 = headL2.next;
            result = result.next;
        }
        return ret;
    }



}