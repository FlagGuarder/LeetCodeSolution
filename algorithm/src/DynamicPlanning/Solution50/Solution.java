package DynamicPlanning.Solution50;

public class Solution {
    //1025. Divisor Game 除数博弈
    public boolean divisorGame(int N) {
        /*
        * 解题思路；
        *   利用动态规划的思想，利用一个dp数组存储计算结果，dp[i]表示当N为i时，先手的输赢情况
        *   什么情况d[i]先手能赢？
        *   思考一下，你可以发现如果，如果i存在有一个因数j（ 0 < j < i), 且dp[i-j]=false，即先手为输的情况
        *   这时候dp[i]先手就是赢的
        *   例子如下：
        *   dp[1] = false
        *   dp[2] = true
        *   dp[3] = false
        *   dp[4] = true
        *   以i为4作为例子，4的因式分解有1*4，2*2,4可以找到因数1，使得dp[4-1],即dp[3]=false
        *   所以i为4时，先手可以获胜
        * */
        //多开辟空间，避免数组越界
        boolean[] dp = new boolean[N+10];
        //初试化
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= N; ++i){
            for (int j = 1; j < i; ++j){
                //i存在因数j,且i-j先手情况为输，则i先手赢
                if (i % j == 0 && !dp[i-j])
                    dp[i] = true;
            }
        }
        return dp[N];
    }
}
