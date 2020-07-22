package Array.Solution46;

public class Solution {
    //35. 搜索插入位置

    /*
    * 优化思路：
    *   因为是有序数组，计算数组首尾两个值的平均值，然后对比target，确定从头开始遍历还是从尾部开始遍历。
    * */
    public int searchInsert(int[] nums, int target) {
        //一遍过，时间百分百，有简单优化。
        int ans = 0;
        int n = nums.length;
        int mid ;
        if (n == 0)
            return 0;
        boolean flag = true;
        int index;
        //首尾两个数的平均值
        mid = nums[0] + nums[n-1];
        //小于平均值，从头开始遍历
        if (target <= mid){
            index = 0;
            while (index < n){
                if (nums[index] == target)
                    return index;
                if (nums[index] > target)
                    return index;
                index++;
            }
        }else {
            //大于平均数，从尾部开始遍历
            index = n-1;
            while (index > 0){
                if (nums[index] == target)
                    return index;
                if (nums[index] < target)
                    return ++index;
                index--;
            }
        }

        return index;
    }
}
