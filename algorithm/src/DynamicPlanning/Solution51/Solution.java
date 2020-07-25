package DynamicPlanning.Solution51;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    //410. Split Array Largest Sum 分割数组的最大值
    /*
    * 解题思路：
    *   本题解法使用的是动态规划：
    *       我们创建一个动态规划数组dp存储计算结果，如dp[i][j]存储的是nums数组前i个数分成j个部分的多种组合中，j个部分和中最大值在多种组合中最小的情况
    *       我们可以将问题分解为子问题，如dp[i][j]可以分解为前k-1个元素分为j-1组，以及一个k到i的部分和（i > k > j）,因为i个元素分成j个部分有多组
    *       情况，所以我们不仅要将问题进行分解 dp[i][j] 分解 为 Integer.max(dp[k-1][j-1],sub[i]-sub[k-1]));
    *       还需要枚举不同的组合情况，即在k的取值范围内，取不同k值，不断尝试不同组合，找出最小值，即
    *          for (int k = j; k <= i; ++k)
    *               dp[i][j] = Integer.min(dp[i][j],Integer.max(dp[k-1][j-1],sub[i]-sub[k-1]));
    *
    * */
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int dp[][] = new int[n + 1][m + 1];
        //由上述推出的动态规划公式初始化dp数组
        for (int i = 1; i <= n; ++i)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        int[] sub = new int[n + 1];
        //计算nums前i+1个元素的和
        for (int i = 0; i < n; ++i)
            sub[i + 1] = sub[i] + nums[i];
/*        //上述中，我们设置所有的元素的值为整数的最大值，动态规划公式中，它是从小计算到到大的，一开始计算时，会访问到dp[0][i]如果不重新设置边界值
        //最后的计算结果会是Integer.MAX_VALUE
        //这个部分可以去掉的，因为创建的时候默认值就是0
        for (int i = 0; i <= m; ++i)
            dp[0][i] = 0;*/
        //计算前i个元素分割为j个部分，j个和中最大值最小的情况
        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= Math.min(i, m); ++j)
                //数组前i个数，分割成i份部分和最大值最小的结果
                for (int k = j; k <= i; ++k)
                    //枚举每个可能的组合
                    dp[i][j] = Integer.min(dp[i][j],Integer.max(dp[k-1][j-1],sub[i]-sub[k-1]));
        return dp[n][m];

    }
}