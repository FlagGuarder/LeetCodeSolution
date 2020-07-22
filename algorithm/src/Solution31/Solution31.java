package Solution31;

public class Solution31 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null)
            return 0;
        int ans = Integer.MIN_VALUE;
        int high = 1; int sigal = 0;
        int index = 0; int n = nums.length;
        while (index < n-1){
            if (nums[index] < nums[index+1]){
                if (sigal != 0){
                    high +=sigal;
                    sigal = 0;
                }
                high++; index++;
                if (high > ans)
                    ans = high;
            }
            else  if (nums[index] > nums[index+1]){
                if (sigal != 0)
                    sigal = 0;
                high = 1; index++;
            }
            else {
                sigal++;
                index++;
            }
        }
        if (ans == Integer.MIN_VALUE)
            ans = 1;

        return ans;
    }
}
