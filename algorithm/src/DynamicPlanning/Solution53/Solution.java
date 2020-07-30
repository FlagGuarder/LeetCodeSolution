package DynamicPlanning.Solution53;

public class Solution {
    //343. Integer Break 整数拆分
    public static int integerBreak(int n) {
        //多开辟空间防止数组越界
        int dp[] = new int[n+5];
        //特殊情况处理
        if (n < 0)
            return -1;
        if (n < 3)
            return 1;
        if (n == 3)
            return 2;
        //计算动态规划数组dp[]
        //d[i]代表i所能拆分的整数的乘积所能取得的最大值，特殊的情况如3如果拆分可能小于3，我们dp中存储的是3
        //然后如果输入是3，我们在上述特殊情况返回3，大于3的值，拆分的整数乘积最大值的大于等于本身的，所以直接返回
        //计算后的dp数组对应的值dp[n]即可
        //特殊情况初始化
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        //计算dp数组
        for (int i = 4; i <= n; i++){
            for (int j = 1; j <= i/2; ++j){
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
