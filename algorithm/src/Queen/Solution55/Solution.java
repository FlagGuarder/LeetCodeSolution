package Queen.Solution55;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 结果集一共有c个元素
        int c = nums.length - k + 1;
        // 避免数组越界
        int[] result = new int[c];
        Deque deque = new LinkedList();
        // 初始化双向队列,并将第一个滑动窗口存进双向队列，并计算计算窗口的最大值
        Integer tempMax = Integer.MIN_VALUE;
        for (int j = 0; j < k; j++){
            deque.addLast(nums[j]);
            if (nums[j] > tempMax){
                tempMax = nums[j];
            }
        }
        for (int i = 0; i < c; i++){
            result[i] = tempMax;
            // 移动窗口
            Integer outElement = (Integer) deque.pollFirst();
            if (i+k < nums.length){
                deque.addLast(nums[i+k]);
                // 移除的等于最大值，重新计算最大值
                if (outElement.equals(tempMax)){
                    if (nums[i+k] >= tempMax){
                        tempMax = nums[i+k];
                    }else {
                        tempMax = findMaxElement(nums,i+1,i+k);
                    }

                }
                 tempMax = tempMax > nums[i+k] ? tempMax : nums[i+k];
            }


        }
        return result;
    }

    private static int findMaxElement(int[] nums,int start, int end){
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++){
            if (nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int ans[] = maxSlidingWindow(nums,3);
        int stop = 0;
    }



}
