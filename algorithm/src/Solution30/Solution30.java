package Solution30;

import java.util.*;

public class Solution30 {
    // 169. 多数元素
    // 问题描述：
    /*
    * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
    你可以假设数组是非空的，并且给定的数组总是存在多数元素。
    * */

    /*
    * 最简单解题思路，利用容器来解题即可，效率有点低而已
    * the most easy way to fix this question is using container ,but the efficient is a little slow
    *   * */

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
