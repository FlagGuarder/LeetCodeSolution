package Array.Solution65;

public class Solution {
    /*
        题目：
            88. 合并两个有序数组

            给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

            初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。

            题目链接：
                https://leetcode-cn.com/problems/merge-sorted-array/

    *   思路：
    *       根据题目中的描述，提供的数据是两个有序的数组，并且已知两个数组的长度，而且题目中告诉我们num1的长度是足够容下两个数组中的所有数据；
            因此我们可以选择将两个数组中的原始数据从最后开始，进行排序，填入nums1的尾部，从而实现排序，具体实现如下。
    *
    * */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n -1;
        int index1 = m-1;
        int index2 = n-1;
        while(index1 >=0 && index2 >= 0){
            if (nums2[index2] >= nums1[index1]){
                nums1[k--] = nums2[index2--];
            }else {
                nums1[k--] = nums1[index1--];
            }
        }
        while(index2 >=0){
            nums1[k--] = nums2[index2--];
        }
        return;
    }
}
