package Array.Solution58;
/*
* 1423. 可获得的最大点数
几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
你的点数就是你拿到手中的所有卡牌的点数之和。
给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
题目链接：https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/
*
该题目可以理解为你需要在左边连续取i个值之和，右边取连续j个值之和，且i+j=k，返回其中的最大值即可，
* 我这里是先计算左边连续取i个值的数组，和计算右边连续j个值的数组，然后遍历一下，找到最大的值，思路比较简单
*
* */
public class Solution {
    public static int maxScore(int[] cardPoints, int k) {
        int result = Integer.MIN_VALUE;
        int length = cardPoints.length;
        int[] leftSumArray = new int[length];
        leftSumArray[0] = cardPoints[0];
        int[] rightSumArray = new int[length];
        rightSumArray[length-1] = cardPoints[length-1];
        for (int i =1,j = cardPoints.length-2; i < cardPoints.length; i++,j--){
            leftSumArray[i] = leftSumArray[i-1] + cardPoints[i];
            rightSumArray[j] = rightSumArray[j+1] + cardPoints[j];
        }
        for (int i =0; i <k-1;i++){
            if (leftSumArray[i] + rightSumArray[length+1-k+i] > result){
                result = leftSumArray[i] + rightSumArray[length+1-k+i];
            }
        }
        result = leftSumArray[k-1] > result ? leftSumArray[k-1] : result;
        result = rightSumArray[length-k] > result ? rightSumArray[length-k] : result;
    return result;
    }

    public static void main(String[] args) {
        int[] nums={1,1000,1};
        System.out.println(maxScore(nums,1));
    }
}
