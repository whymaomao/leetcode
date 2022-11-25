package com.company;

import java.util.*;

public class week_318 {
    public int[] applyOperations(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len - 1; i ++) {
            if(nums[i + 1] == nums[i]) {
                nums[i] = 2*nums[i];
                nums[i+1] = 0;
            }
        }
        int left = 0;
        int right = left + 1;
        while(left < len && right < len) {
            if(nums[left] == 0 && nums[right] != 0) {
                nums[left] = nums[right];
                nums[right] = 0;
            }
            while(nums[left] != 0 && left < len) {
                left ++;
            }
            right = left + 1;
            while(nums[right] == 0 && right < len) {
                right ++;
            }
        }
        return nums;
    }

    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> numFreq = new HashSet<>();
        int sum = 0;
        int maxSum = 0;
        for(int i = 0; i < k; i ++) {
            sum += nums[i];
            numFreq.add(nums[i]);
        }
        if(numFreq.size() == k) {
            maxSum = sum;
        }

        for(int i = 1; i <= nums.length -k ; i ++) {
            sum -= nums[i - 1];
            sum += nums[i + k - 1];
            numFreq.remove(nums[i-1]);
            numFreq.add(nums[i+k-1]);
            if(numFreq.size() == k) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedSet = new HashSet<>();
        for(int i = 0; i < allowed.length(); i ++) {
            allowedSet.add(allowed.charAt(i));
        }
        int result = 0;
        for(String word : words) {
            boolean flag = true;
            for(int i = 0; i < word.length(); i ++) {
                if(!allowedSet.contains(word.charAt(i))) {
                    flag = false;
                }
            }
            if(!flag) {
                result ++;
            }
        }
        return result;
    }


    static class WorkerCandidate {
        Integer cost;
        Integer workerLocation;

        WorkerCandidate(int cost, int workerLocation) {
            this.cost = cost;
            this.workerLocation = workerLocation;
        }
    }

    /**
     * 输入：costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
     * 输出：11
     * 解释：我们总共雇佣 3 位工人。总代价一开始为 0 。
     * - 第一轮雇佣，我们从 [17,12,10,2,7,2,11,20,8] 中选择。最小代价是 2 ，有两位工人，我们选择下标更小的一位工人，即第 3 位工人。总代价是 0 + 2 = 2 。
     * - 第二轮雇佣，我们从 [17,12,10,7,2,11,20,8] 中选择。最小代价是 2 ，下标为 4 ，总代价是 2 + 2 = 4 。
     * - 第三轮雇佣，我们从 [17,12,10,7,11,20,8] 中选择，最小代价是 7 ，下标为 3 ，总代价是 4 + 7 = 11 。注意下标为 3 的工人同时在最前面和最后面 4 位工人中。
     * 总雇佣代价是 11 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/total-cost-to-hire-k-workers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param costs
     * @param k
     * @param candidates
     * @return
     */
    public static long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<WorkerCandidate> costPriorityQueue = new PriorityQueue<>(k, new Comparator<WorkerCandidate>() {
            @Override
            public int compare(WorkerCandidate o1, WorkerCandidate o2) {
                if(o1.cost.equals(o2.cost)) {
                    return o1.workerLocation - o2.workerLocation;
                } else {
                    return o1.cost - o2.cost;
                }
            }
        });
        long sumCost = 0;
        int totalLen = costs.length;
        int left_end = candidates - 1;
        int right_start = totalLen - candidates;
        if(2*candidates < totalLen) {
            for (int i = 0; i < candidates; i++) {
                costPriorityQueue.offer(new WorkerCandidate(costs[i], i));
            }
            for(int i = right_start; i < totalLen; i ++) {
                costPriorityQueue.offer(new WorkerCandidate(costs[i], i));
            }
        } else {
            for(int i = 0; i < totalLen; i ++) {
                costPriorityQueue.offer(new WorkerCandidate(costs[i], i));
            }
        }

        for(int count = 0; count < k; count ++) {
            if(!costPriorityQueue.isEmpty()) {
                WorkerCandidate smallWorkerCandidate = costPriorityQueue.poll();
                sumCost += smallWorkerCandidate.cost;
                if(2*candidates >= totalLen) {
                    continue;
                } else {
                    int location = smallWorkerCandidate.workerLocation;
                    if(location <= left_end) {
                        costPriorityQueue.offer(new WorkerCandidate(costs[left_end + 1], left_end + 1));
                        left_end += 1;
                    } else {
                        costPriorityQueue.offer(new WorkerCandidate(costs[right_start - 1], right_start -1));
                        right_start -= 1;
                    }
                }
                totalLen -= 1;
            }
        }

        return sumCost;
    }

    public static void main(String[] args) {
        System.out.println(totalCost(new int[] {31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58}, 11,2));
    }
}
