package com.company;

import java.util.*;

public class week_391_meituan {

    /**
     * 给你一个四舍五入到两位小数的非负浮点数 celsius 来表示温度，以 摄氏度（Celsius）为单位。
     *
     * 你需要将摄氏度转换为 开氏度（Kelvin）和 华氏度（Fahrenheit），并以数组 ans = [kelvin, fahrenheit] 的形式返回结果。
     *
     * 返回数组 ans 。与实际答案误差不超过 10-5 的会视为正确答案。
     *
     * 注意：
     *
     * 开氏度 = 摄氏度 + 273.15
     * 华氏度 = 摄氏度 * 1.80 + 32.00
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/convert-the-temperature
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param celsius
     * @return
     */
    public double[] convertTemperature(double celsius) {
        return new double[] {celsius + 273.15 , celsius * 1.80 + 32.00};
    }


    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 nums 的 子数组 中满足 元素最小公倍数为 k 的子数组数目。
     *
     * 子数组 是数组中一个连续非空的元素序列。
     *
     * 数组的最小公倍数 是可被所有数组元素整除的最小正整数。
     * 示例 1 ：
     *
     * 输入：nums = [3,6,2,7,1], k = 6
     * 输出：4
     * 解释：以 6 为最小公倍数的子数组是：
     * - [3,6,2,7,1]
     * - [3,6,2,7,1]
     * - [3,6,2,7,1]
     * - [3,6,2,7,1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/number-of-subarrays-with-lcm-equal-to-k
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */


    /**
     * 最大公约数
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a,int b){
        return b > 0 ? gcd(b,a%b) : a;
    }


    /**
     * 最小公倍数*最大公约数就是最小公倍数
     * @param a
     * @param b
     * @return
     */
    public int lcm(int a,int b){
        return a / gcd(a,b) * b;
    }

    public int subarrayLCM(int[] nums, int k) {
        int result = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] == k) {
                result ++;
            }
            int temp = nums[i];
            for(int j = i + 1; j < nums.length; j ++) {
                    temp = lcm(temp, nums[j]);
                    if(temp == k) {
                        result ++;
                    }
                    if(temp > k) {
                        break;
                    }
            }
        }
        return result;
    }

    private int changeOrderCount(List<Integer> treeList) {
        int count = 0;
        Map<Integer, Integer> treeMap = new HashMap<>();
        for(int index = 0; index < treeList.size(); index ++) {
            treeMap.put(treeList.get(index), index);
        }
        int[] originalList = treeList.stream().mapToInt(Integer::valueOf).toArray();
        int[] copyList = Arrays.copyOf(originalList, treeList.size());

        Arrays.sort(copyList);
        for(int index = 0; index < copyList.length; index ++) {
            int rawLocation = treeMap.get(copyList[index]);
            if(rawLocation == index) {
                continue;
            } else {
                // change location
                treeMap.put(copyList[index], index);
                treeMap.put(originalList[index], rawLocation);
                originalList[index] = copyList[index];
                originalList[rawLocation] = originalList[index];
                count ++;
            }
        }

        return count;
    }

    public int minimumOperations(TreeNode root) {
        // loop the tree
        int result = 0;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        if(root != null) {
            treeNodeQueue.offer(root);
        }
        while(!treeNodeQueue.isEmpty()) {
            int treeLevelSize = treeNodeQueue.size();
            List<Integer> treeList = new ArrayList<>(treeLevelSize);
            for(int i = 0; i < treeLevelSize; i ++) {
                TreeNode temp = treeNodeQueue.poll();
                if(temp != null) {
                    treeList.add(temp.val);
                    if (temp.left != null) {
                        treeNodeQueue.offer(temp.left);
                    }
                    if (temp.right != null) {
                        treeNodeQueue.offer(temp.right);
                    }
                }
            }
            result += changeOrderCount(treeList);
        }
        return result;
    }
}
