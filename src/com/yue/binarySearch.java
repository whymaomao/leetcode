package com.yue;

public class binarySearch {
    public int searchInsert(int[] nums, int target) {
      // find the last position which is less than target
       int start = 0;
       int end = nums.length - 1;
       int mid = 0;
       if(nums[0] >= target) {
         return 0;
       }
       if(nums[nums.length - 1] < target) {
         return nums.length;
       }
       while(start <= end) {
         mid = start + (end - start) / 2;
         if( mid != 0 && (nums[mid] == target && nums[mid - 1] < target)) {
           return mid;
         } else if(nums[mid] > target){
           end = mid  - 1;
         } else {
           start = mid + 1;
         }
       }
       return mid;
    }

    public int peakIndexInMountainArray(int[] arr) {
        int start = 1;
        int end = arr.length - 2;
        int mid = 0;
        while(start <= end) {
          mid = start + ( end - start ) / 2;
          if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])  {
            return  mid;
          } else if(arr[mid-1] < arr[mid] && arr[mid] < arr[mid + 1]) {
              start = mid + 1;
          } else {
            end = mid - 1;
          }
        }
        return -1;
    }


    public int singleNonDuplicate(int[] nums) {
        int result = 0;
        for(int num : nums) {
            result = result ^ num;
        }
        return result;
    }

}
