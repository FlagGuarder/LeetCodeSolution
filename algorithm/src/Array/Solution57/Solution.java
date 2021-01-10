package Array.Solution57;

import java.util.ArrayList;
import java.util.List;

// 228. 汇总区间
// 228. Summary Ranges、
// 题目地址：https://leetcode-cn.com/problems/summary-ranges/
/*
*  解题思路： 主要是是因为是有序数组，所以我们可以利用这个特点，遍历当前节点时，检查前一个节点与当前节点的数组之差，如果
*  相同，就继续便利下一个节点，如果相差一，也继续遍历下一个节点，在当前节点与前一个节点不连续时，做一下特殊处理，可能出现的方式
*  有两种，一种当前节点前面的区间都是同一个数字，那么只需要存入那个数字即可，如果是一个区间，就转换为题目中需要的字符串形式。
*  解题流程如下
* */
public class Solution {
    public static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int n = nums.length;
        // 当源数组是空数组时，做特殊处理
        if (n == 0){
            return ans;
        }
        String item = "";
        // 极端情况1, 一个数组只有一个数组成
        // 到最后一个节点的时候处理一一下
        for (int i = 0; i < n; i++){
            if (item.length()==0){
                // 重新计算下一个区间
                item += nums[i];
            }else {
                // 连续的情况
                if (nums[i]-nums[i-1]==1 || nums[i]-nums[i-1]==0){
                    continue;
                }else {
                    // 不连续情况
                    if (item.equals(nums[i-1]+"")){
                        ans.add(item);
                    }else {
                        ans.add(item+"->"+nums[i-1]);
                    }
                    item = nums[i]+"";
                }
            }
        }
        // 结尾情况处理
        if (n >1 && nums[n-1]-nums[n-2] == 0){
            ans.add(item);
        }else if (n > 1 && nums[n-1]-nums[n-2]==1){
            ans.add(item+"->"+nums[n-1]);
        }else {
            ans.add(item);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,3,4,6,8,9};
        List<String> ans = summaryRanges(nums);
        int i =0;
    }
}
