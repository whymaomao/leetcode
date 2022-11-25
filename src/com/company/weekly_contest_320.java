package com.company;

import java.util.HashMap;
import java.util.Map;

public class weekly_contest_320 {
    /**
     * 给你一个下标从 0 开始的正整数数组 nums 。请你找出并统计满足下述条件的三元组 (i, j, k) 的数目：
     *
     * 0 <= i < j < k < nums.length
     * nums[i]、nums[j] 和 nums[k] 两两不同 。
     * 换句话说：nums[i] != nums[j]、nums[i] != nums[k] 且 nums[j] != nums[k] 。
     * 返回满足上述条件三元组的数目。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/number-of-unequal-triplets-in-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }
        if(numMap.size() < 3) {
            return 0;
        }
        int ans = 1;
        for(Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            ans = ans * entry.getValue();
        }
        return ans;
    }
}
