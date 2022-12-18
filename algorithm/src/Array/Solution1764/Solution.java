package Array.Solution1764;

public class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int i = 0;
        for (int k = 0; k < nums.length && i < groups.length;){
            if (check(groups[i],k,nums)){
                k+=groups[i].length;
                i++;
            }else {
                k++;
            }
        }
        return i == groups.length;
    }

    private boolean check(int[] group,int k, int[] nums){
        if (k+group.length > nums.length){
            return false;
        }
        for (int j = 0; j < group.length; j++){
            if (group[j] != nums[k+j]){
                return false;
            }
        }
        return true;
    }
}
