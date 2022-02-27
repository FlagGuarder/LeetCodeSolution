package DynamicPlanning.MaxiDeferdence;

public class Solution {
    public int maximumDifference(int[] nums) {
        int ans = -1;
        if (nums==null || nums.length==0)
            return ans;
        int preMin = nums[0];
        for (int i = 1; i<nums.length;i++){
            if (nums[i] > preMin){
                ans = Math.max(nums[i] - preMin,ans);
            }else {
                preMin = nums[i];
            }
        }
        return ans;
    }
}
