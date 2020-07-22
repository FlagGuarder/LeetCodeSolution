package Solution30;

import java.util.*;

public class Solution30 {
    public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new LinkedHashMap<>();
        int ans=0;
        int times = Integer.MIN_VALUE;
        int i = 0; int n = nums.length;
        while (i < n){
            if (map.containsKey(nums[i])){
                map.replace(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
            i++;
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){

            if (entry.getValue() > times) {
                times = entry.getValue();
                ans = entry.getKey();
            }
        }
        return ans;
    }
}
