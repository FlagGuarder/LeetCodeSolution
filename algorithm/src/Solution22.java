import java.util.Arrays;

public class Solution22 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int start,end;
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n; i++){
            start = i + 1;   end = n - 1;
            while (start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target-sum) < Math.abs(target-ans)){
                    ans = sum;
                }
                if (sum > target)
                    end--;
                else if (sum < target)
                    start++;
                else
                    return ans;
            }
        }

        return ans;
    }
}
