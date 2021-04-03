package DynamicPlanning.Solution61;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        /*
          题目描述：
          给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。

            一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。

            例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
            两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/longest-common-subsequence
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

        示例 1：

            输入：text1 = "abcde", text2 = "ace"
            输出：3
            解释：最长公共子序列是 "ace" ，它的长度为 3 。

        * 思路：
        *       设dp[n+1][m+1] 存储的是text1前n个元素和text2前m个元素最长公共子串长度
        *       题目所求的答案的是两个字符串的最长公共子串，即dp[len1][len2]（len1为text1长度，len2为text2长度）
        *       此题目可以利用动态规划解决，同时也是经典的动态规划问题，需要将问题划分为更详细的子问题
        *       我们需要计算dp[n+1][m+1] 的最长公共子串，需要将问题进行分解，我们可以发现d[n+1][m+1]的计算是建立
        *       在d[n][m]的基础上的，
        *       假设dp[n][m]已知，即text1[n-1]与text2[m-1]的最长公共子串已知的情况下，
        *       要计算dp[n+1][m+1]，即text1[n]与text2[m]的最长公共子串长度，
        *       会出现以下情况
        *       1.当text1[n]==text2[m] 时，我们就知道了text1[n]与text2[m]的最长公共子串，
        *       为text1[n-1]和text2[m-1]的最长公共子串加上公共字符text1[n](text2[2])
        *       且得到长度为dp[n+1][m+1]为dp[n][m] + 1
        *       2.当text1[n]！=text2[m] 时
        *       在我们已知text1[n-1]与text2[m-1]最长公共子串（长度为dp[n][m）的情况下，需要计算text1[n]和
        *       text2[m]的最长公共子串，会出现两种产生新最长子串的情况
        *       1.text1[n]与text2[m-1]的最长公共子串
        *       2.text1[n-1]与text2[m]的最长公共子串
        *       此时text1[n]与text2[m]的最长公共子串为这两种子串长度较长者，新的最长公共子串长度
        *       dp[n+1][m+1] = max (dp[n][m+1],dp[n+1][m])
        *
        *       边界情况考虑：
        *       1.两字符串的任意字符串长度威零时，最长公共子串为""，长度为0即
        *       dp[0][j] = 0; (0<=j<=len2,len2 为text2长度)
        *       dp[i][0] = 0; (0<=i<=len1,len1 为text1长度)
        *
        *       动态规划方程如下：
        *       dp[i][j] = dp[i-1][j-1] + 1; text1[i-1]==text2[j-1]
        *       dp[i][j] = max(dp[i][j-1],dp[i-1][j]); ext1[i-1]!=text2[j-1]
        * */
        int len1 = text1.length();
        int len2 = text2.length();
        char ch1,ch2;
        int dp[][] = new int[len1+1][len2+1];
        for (int i = 1; i <= len1; i++){
            ch1 = text1.charAt(i-1);
            for (int j = 1; j <= len2; j++){
                ch2 = text2.charAt(j-1);
                if (ch1 == ch2){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = dp[i-1][j] > dp[i][j-1] ? dp[i-1][j] : dp[i][j-1];
                }
            }
        }
        return dp[len1][len2];
    }
}
