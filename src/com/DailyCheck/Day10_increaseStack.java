package com.DailyCheck;

import java.util.*;


/**
 * 单调栈practice
 * No 739 每日温度
 * No 496 next greater element 1
 * No 42 接雨水
 *
 */

public class Day10_increaseStack {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];

        Deque<Integer> dailyStack = new LinkedList<>();
        dailyStack.push(0);
        for(int i = 1; i < len; i ++) {
            int currentTemp = temperatures[i];
            while(!dailyStack.isEmpty() && temperatures[dailyStack.peek()] < currentTemp ){
                result[dailyStack.peek()] = i - dailyStack.peek();
                dailyStack.pop();
            }
            dailyStack.push(i);
        }
        return result;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] result = new int[len1];

        Map<Integer, Integer> stackMap = new HashMap<>();
        Deque<Integer> nextGreaterStack = new LinkedList<>();

        nextGreaterStack.push(0);
        stackMap.put(nums2[0], -1);
        for(int i = 1; i < len2; i ++) {
            int currentElement = nums2[i];
            stackMap.put(nums2[i], -1);
            while(!nextGreaterStack.isEmpty() && nums2[nextGreaterStack.peek()] < currentElement) {
                stackMap.put(nums2[nextGreaterStack.peek()], i );
                nextGreaterStack.pop();
            }
            nextGreaterStack.push(i);
        }

        for(int j = 0; j < len1; j ++) {
            if(stackMap.get(nums1[j]) == -1 ) {
                result[j] = -1;
            } else {
                result[j] = nums2[stackMap.get(nums1[j])];
            }
        }
        return result;

    }

    public static int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] tempDoubleNums = new int[len + len];
        for(int i = 0 ; i < len; i ++) {
            tempDoubleNums[i] = nums[i];
            tempDoubleNums[i + len] = nums[i];
        }
        int[] result = new int[len];
        Arrays.fill(result, -1);
        Deque<Integer> stackNums = new LinkedList<>();

        stackNums.push(0);
        for(int i = 1; i < len * 2; i ++) {
            while(!stackNums.isEmpty() && tempDoubleNums[stackNums.peek()] < tempDoubleNums[i]) {
                int tempIndex = stackNums.peek() % len;
                if(result[tempIndex] == -1) {
                    result[tempIndex] = tempDoubleNums[i];
                }
                stackNums.pop();
            }
            stackNums.push(i);
        }

        return result;
    }

    public int trap(int[] height) {
        int len = height.length;
        int trap = 0;
        Deque<Integer> stackHeight = new LinkedList<>();
        int[] trapArray = new int[len];
        Arrays.fill(trapArray, -1);

        stackHeight.push(0);
        for(int i = 1; i < len; i ++) {
            while(!stackHeight.isEmpty() && height[stackHeight.peek()] <= height[i]) {
                trapArray[stackHeight.peek()] = i;
                stackHeight.pop();
            }
            stackHeight.push(i);
        }

        int maxHeightIndex = 0 ;
        int startIndex = 0;
        int width = 0;
        for(int j = 0; j < trapArray.length; j ++) {
            if(trapArray[j] != -1) {
                if(maxHeightIndex > j) {
                    startIndex = j;
                    maxHeightIndex = j;
                }
            }
        }
        return trap;
    }

    public static void main(String[] args) {
        int[] num1 = {4,1,2};
        int[] nums2 = {1,2,3,4,3};
        Arrays.stream(nextGreaterElements(nums2)).forEach(System.out::println);
    }

}
