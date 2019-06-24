package com.company;

public class No88_MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index_nums1 = 0;
        int index_nums2 = 0;
        int index = 0;

        int[] result = new int[m+n+1];


        while(index_nums1 < m || index_nums2 < n )
        {
            if((index_nums1 < m && nums1[index_nums1] <= nums2[index_nums2]) || index_nums2 == n)
            {
                result[index] = nums1[index_nums1];
                index_nums1 ++;
                index ++;
                continue;
            }
            if((index_nums2 < n && nums1[index_nums1] > nums2[index_nums2]) || index_nums1 == m ){
                result[index] = nums2[index_nums2];
                index_nums2 ++;
                index ++;
                continue;
            }

        }
        for(int i = 0; i < nums1.length; i ++)
        {
            nums1[i] = result[i];
        }
    }

    public void newMerge(int[] nums1, int m, int[] nums2, int n){
        int index = m + n;

        while(index >= 0)
        {


        }

    }
}
