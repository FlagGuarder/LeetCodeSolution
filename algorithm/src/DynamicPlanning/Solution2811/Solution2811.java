package DynamicPlanning.Solution2811;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*
* 给你一个长度为 n 的数组 nums 和一个整数 m 。请你判断能否执行一系列操作，将数组拆分成 n 个 非空 数组。

在每一步操作中，你可以选择一个 长度至少为 2 的现有数组（之前步骤的结果） 并将其拆分成 2 个子数组，而得到的 每个 子数组，至少 需要满足以下条件之一：

子数组的长度为 1 ，或者
子数组元素之和 大于或等于  m 。
如果你可以将给定数组拆分成 n 个满足要求的数组，返回 true ；否则，返回 false 。

注意：子数组是数组中的一个连续非空元素序列。



示例 1：

输入：nums = [2, 2, 1], m = 4
输出：true
解释：
第 1 步，将数组 nums 拆分成 [2, 2] 和 [1] 。
第 2 步，将数组 [2, 2] 拆分成 [2] 和 [2] 。
因此，答案为 true 。
示例 2：

输入：nums = [2, 1, 3], m = 5
输出：false
解释：
存在两种不同的拆分方法：
第 1 种，将数组 nums 拆分成 [2, 1] 和 [3] 。
第 2 种，将数组 nums 拆分成 [2] 和 [1, 3] 。
然而，这两种方法都不满足题意。因此，答案为 false 。
示例 3：

输入：nums = [2, 3, 3, 2, 3], m = 6
输出：true
解释：
第 1 步，将数组 nums 拆分成 [2, 3, 3, 2] 和 [3] 。
第 2 步，将数组 [2, 3, 3, 2] 拆分成 [2, 3, 3] 和 [2] 。
第 3 步，将数组 [2, 3, 3] 拆分成 [2] 和 [3, 3] 。
第 4 步，将数组 [3, 3] 拆分成 [3] 和 [3] 。
因此，答案为 true 。
*
* */
public class Solution2811 {


/*
* 动态规划方程：
* dynamic[i][i]=true
* len = 2
* dynamic[i][i+len-1] = nums[i] + nums[i+1] >= m
* len>=3
* dynamic[i][i+len-1] = dynamic[i][i+len-2] || dynamic[i+1][i-len+1]
*
* */
    public static boolean canSplitArray(List<Integer> nums, int m) {
        int n = nums.size();
        boolean dynamic[][] = new boolean[n][n];
        boolean result = false;
        if (nums.size() <=2 )
            return true;
        for (int i=0; i < n; i++){
            dynamic[i][i] = true;
        }
        for (int i =0; i<= n-2; i++){
            dynamic[i][i+1] = (nums.get(i) + nums.get(i+1)) >= m;
            // 优化
            result = result || dynamic[i][i+1];
        }
        if (!result){
            return false;
        }
        for (int j = 3; j <= n; j ++){
            for (int i=0; i < n - j+1; i ++){
                dynamic[i][i+j-1] = dynamic[i][i+j-2] || dynamic[i+1][i+j-1];
            }
        }
        return dynamic[0][n-1];
    }
/*
* 优化版本：非动态规划版本
*
* 题目要求：分割数组，两个子数组必须满足两个条件之一：
* 1. 数组长度为1
* 2. 数组各元素之和>=m
* 我们可以发现，只要有两个相邻数组元素之和>=m，无论后续数组长度多长，我们都可以将数组进行拆分
*
* 所以题目意义变为，只要数组存在两个相邻元素之和>=m，即问题有解
* */
    public static boolean canSplitArray1(List<Integer> nums, int m) {
        int n = nums.size();
        if (nums.size() <=2 )
            return true;

        for (int i =0; i<= n-2; i++){
            if ((nums.get(i) + nums.get(i+1)) >= m)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(2, 3, 3, 2, 3);
        List<Integer> integers1 = Arrays.asList(2, 1, 3);
        List<Integer> integers2 = Arrays.asList(2, 2, 1);

        canSplitArray(integers,6);
        canSplitArray(integers1,5);
        canSplitArray(integers2,4);

    }
}
