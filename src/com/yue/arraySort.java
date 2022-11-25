package com.yue;

import java.util.HashMap;
import java.util.Map;

public class arraySort {
  public static int mySqrt(int x) {
    int start = 0;
    int end = x;
    int mid  = 0;
    while(start <= end ) {
      mid = start + (end - start)/2 + 1;
      int temp = x / mid;
      int temp2 = x / (mid + 1);
      if(temp >= mid && temp2 < (mid + 1)){
        return mid;
      }
      if(temp < mid) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return mid;
  }
  public static void main(String[] args) {
    System.out.println(mySqrt(8));
  }

}
