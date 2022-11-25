package com.company;

import java.util.Arrays;

public class No724_pivotIndex {

  public int pivotIndex(int[] nums) {
    int lastIndex = nums.length;
    int[] sumLeft = new int[lastIndex + 2];
    int[] sumRight = new int[lastIndex+ 2];
    sumLeft[0] = 0;
    sumRight[lastIndex + 1] = 0;
    for(int i = 1; i <lastIndex +1 ; i ++) {
      sumLeft[i] = sumLeft[i-1] + nums[i -1];
    }
    sumLeft[lastIndex + 1] = sumLeft[lastIndex];

    for(int i = lastIndex ; i >= 1; i --) {
      sumRight[i] = sumRight[i+1] + nums[i -1];
    }
    sumRight[0] = sumRight[1];

    for(int i = 1; i < lastIndex + 1; i ++) {
      if(sumLeft[i] == sumRight[i]) {
        return i - 1;
      }
    }
    return -1;

  }


  public boolean isAnagram(String s, String t) {
     int[] letterNum = new int[26];
     for(int i = 0; i < s.length(); i ++) {
        letterNum[s.charAt(i) - 'a'] ++;
     }

     for(int j = 0; j < t.length(); j ++) {
       char tempValue = t.charAt(j);
       if(letterNum[tempValue] == 0) {
         return  false;
       } else {
         letterNum[tempValue] --;
       }
     }

     return Arrays.stream(letterNum).noneMatch(num -> num !=0);

  }

}
