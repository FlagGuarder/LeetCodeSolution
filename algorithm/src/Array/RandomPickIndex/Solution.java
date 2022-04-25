package Array.RandomPickIndex;

import java.util.*;

public class Solution {
    private HashMap<Integer, List<Integer>> indexMap = new HashMap();
    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            if (indexMap.containsKey(nums[i])){
                indexMap.get(nums[i]).add(i);
            }else {
                int finalI = i;
                indexMap.put(nums[i],new ArrayList<>(){{add(finalI);}});
            }
        }
    }

    public int pick(int target) {
        Random random = new Random();
        List<Integer> integers = indexMap.get(target);
        return integers.get(random.nextInt(integers.size()));
    }
}
