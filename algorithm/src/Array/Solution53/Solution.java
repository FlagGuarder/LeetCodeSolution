package Array.Solution53;

public class Solution {
    //  面试题 08.03. Magic Index LCCI  魔术索引
    // https://leetcode-cn.com/problems/magic-index-lcci/
    public int findMagicIndex(int[] nums) {
        //没难度的题，基本就是比较，找到返回，没找到就返回-1，没了，惊不惊喜，意不意外
        int n = nums.length;
        for (int i = 0; i < n; ++i){
            if (nums[i] == i)
                return i;
        }

        return -1;
    }


    public static void main(String[] args) {
        int [] nums = {3,4,4};
        /*findMagicIndex(nums);*/
    }
}
