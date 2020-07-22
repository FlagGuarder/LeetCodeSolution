import java.util.HashSet;
import java.util.Set;

public class Solution10 {
    /*查找相同数字*/
    public int findRepeatNumber(int[] nums) {
        int ans = -1;
        Set<Integer> set = new HashSet<Integer>();
        int i = 0;
        while (i < nums.length){
            if (!set.add(nums[i]));{
                ans = nums[i];
                break;

            }
        }
        return ans;
    }
}
