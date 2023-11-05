package bit.Solution270;

public class Solution {
    int yhOfNums = 0;
    int ans1 = 0;
    int ans2 = 0;
    public int[] singleNumber(int[] nums) {
        for (int num : nums){
            yhOfNums ^= num;
        }
        for (int i = 0; i < 32; i++){
            for (int num : nums){
            }
            
        }
        return nums;
    }
}
