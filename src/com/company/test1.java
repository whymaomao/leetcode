package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.lang.reflect.Array;

public class test1 {
  public boolean checkString(String s) {
      int start = 0;
      int end = s.length() - 1;
      while(start < end) {
        char leftChar = s.charAt(start);
        char rightChar = s.charAt(end);
        if(leftChar == 'b' && rightChar == 'a') {
          return false;
        } else if(leftChar == 'b'&& rightChar == 'b') {
          end --;
        } else if(rightChar == 'a'&& leftChar == 'a') {
          start ++;
        } else {
          end --;
          start ++;
        }
      }
      return true;
  }


  public int numberOfBeams(String[] bank) {
    List<Integer> rules = new ArrayList<>();

    for(String beams : bank) {
      int sizeOfBeams = 0;
      for(int i = 0; i < beams.length(); i ++) {
        if(beams.charAt(i) == '1') {
          sizeOfBeams ++;
        }
      }
      if(sizeOfBeams != 0)
      rules.add(sizeOfBeams);
    }

    int result = 0;
    int len = rules.size();
    if( len == 1) return 0;
    for(int i = 0; i < len - 1; i ++) {
      result += rules.get(i) * rules.get(i + 1);
    }

    return result;
  }

  int findLastLargetNum(int target, int[] asteroids, int start, int end) {
        for(int i = start; i < end; i --) {
          if(asteroids[i] >= target) {
            return i;
          }
        }
        return -1;
//      while(start < end) {
//        int middle = start + (end - start) / 2;
//        if(asteroids[middle] == target) {
//          return middle;
//        } else if (asteroids[middle] > target ) {
//          end = middle;
//        } else {
//          start = middle + 1;
//        }
//      }
//      return -1;
  }

  public boolean asteroidsDestroyed(int mass, int[] asteroids) {
    Arrays.sort(asteroids);
    int len = asteroids.length;
    int largetAsteroid = asteroids[len - 1];
    long sumAsteroid = mass;
    for(int asteroid : asteroids) {
      if(sumAsteroid >= largetAsteroid) return true;
      if(sumAsteroid < asteroid) {
        return false;
      }
      sumAsteroid += asteroid;
    }

    return false;
  }


  // java 堆
  public int[] getOrder(int[][] tasks) {
    int tasksSize = tasks.length;
    int[][] nts = new int[tasksSize][3];
    int index = 0;
    for(int[] task : tasks) {
      nts[index] = new int[]{task[0], task[1], index};
      index ++;
    }
    Arrays.sort(nts, Comparator.comparingInt(a -> a[0]));
    PriorityQueue<int[]> taskPriorityQueue = new PriorityQueue<>((a,b)->{
      if (a[1] != b[1]) return a[1] - b[1];
      return a[2] - b[2];
    });
    int[] resultOrder = new int[tasksSize];

    for(int time = 1, j = 0, idx = 0; idx < tasksSize;) {
      while (j < tasksSize && nts[j][0] <= time) taskPriorityQueue.add(nts[j++]);
      if (taskPriorityQueue.isEmpty()) {
        // 如果当前「队列」没有任务，直接跳到下个任务的入队时间
        time = nts[j][0];
      } else {
        // 如果有可执行任务的话，根据优先级将任务出队（记录下标），并跳到该任务完成时间点
        int[] cur = taskPriorityQueue.poll();
        resultOrder[idx++] = cur[2];
        time += cur[1];
      }
    }


    return resultOrder;
  }


  public int[] getOrder2(int[][] ts) {
    int n = ts.length;
    // 将 ts 转存成 nts，保留任务编号
    int[][] nts = new int[n][3];
    for (int i = 0; i < n; i++) nts[i] = new int[]{ts[i][0], ts[i][1], i};
    // 根据任务入队时间进行排序
    Arrays.sort(nts, (a,b)->a[0]-b[0]);
    // 根据题意，先按照「持续时间」排序，再根据「任务编号」排序
    PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{
      if (a[1] != b[1]) return a[1] - b[1];
      return a[2] - b[2];
    });
    int[] ans = new int[n];
    for (int time = 1, j = 0, idx = 0; idx < n; ) {
      // 如果当前任务可以添加到「队列」中（满足入队时间）则进行入队
      while (j < n && nts[j][0] <= time) q.add(nts[j++]);
      if (q.isEmpty()) {
        // 如果当前「队列」没有任务，直接跳到下个任务的入队时间
        time = nts[j][0];
      } else {
        // 如果有可执行任务的话，根据优先级将任务出队（记录下标），并跳到该任务完成时间点
        int[] cur = q.poll();
        ans[idx++] = cur[2];
        time += cur[1];
      }
    }
    return ans;
  }


  public boolean checkValid(int[][] matrix) {
    int n = matrix.length;
    int[] expected = new int[n];

    for(int i = 0; i < n; i ++) {
      Arrays.fill(expected, 0);
      for(int j = 0; j < n; j ++) {
        expected[matrix[i][j]] ++;
        if(expected[matrix[i][j]] != 1) {
          return false;
        }
      }
    }

    for(int i = 0; i < n; i ++) {
      Arrays.fill(expected, 0);
      for(int j = 0; j < n; j ++) {
        expected[matrix[j][i]] ++;
        if(expected[matrix[j][i]] != 1) {
          return false;
        }
      }
    }
    return true;

  }


  public int minSwaps(int[] nums) {
    int allSteps = nums.length;
    int minSwap = 0;
    int start = -1;
    int end = -1;
    for(int i = 0; i < allSteps ; i ++) {
      if(nums[i] == 0) {
        start = i;
        break;
      }
    }

    for(int i = 0; i < allSteps ; i ++) {
      if(nums[i] == 1) {
        end = i;
        break;
      }
    }

    if(start == -1 || end == -1) {
      return 0;
    }
    int start2 = start;
    int end2 = end;


    int step = 0;
    while(step <= allSteps) {
      if(start == -1) {
        start = allSteps - 1;
      }
      if(end == allSteps) {
        end = 0;
      }
      if(nums[start] == 1 && nums[end] == 0) {
        minSwap ++;
        start --;
        end ++;
        step += 2;
        continue;
      }

      if(nums[start] == 0) {
        start --;
        step ++;
      }

      if(nums[end] == 1) {
        end ++;
        step ++;
      }
    }

    int minSwap2 = 0;
    step = 0;
    while(step <= allSteps) {
      if(start2 == allSteps) {
        start2 = 0;
      }
      if(end2 == -1) {
        end2 = allSteps - 1;
      }
      if(nums[start2] == 1 && nums[end2] == 0) {
        minSwap2 ++;
        start2 ++;
        end2 --;
        step += 2;
        continue;
      }

      if(nums[start2] == 0) {
        start2 ++;
        step ++;
      }

      if(nums[end2] == 1) {
        end2 --;
        step ++;
      }
    }

    return Math.min(minSwap, minSwap2);

  }

  public static void main(String[] args) {
    String testA = "testA";
    String testB = "Testa";

    System.out.println(testA.equalsIgnoreCase(testB));
  }


}
