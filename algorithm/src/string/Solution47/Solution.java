package string.Solution47;
// 97. 交错字符串
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        /*
        * 动态规划思路：
        *   （1）排除不可能的情况：目标字符串s3长度不等于s1，s2长度之和
        *   （2）动态规划情况：
        *          1.现在排除不可能的情况，剩下的情况就是长度为n3的字符串能否由长度n1和长度为n2的字符串组成（n3 = n1 + n2）
        *          2.我们利用一个数组f[][]，来存储不同组合时，能否组成s3前一部分的字符串
        *               如f[i][j]表示s1的前i个字符和s2的前j个字符能否组成s3的前i+j个字符
        *          3.将问题进行分解：
        *               f[i][j]可以分解为(f[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1)) || (f[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1))
        *               s1的前i个字符和s2的前j个字符能否构成s3的前i+j个字符可以分解为：下述中情况的并集
        *                   3.1 s1的前i-1个字符和s2的前j个字符能否构成s3的前i+j-1个字符，且s3的第i+j个字符是否与s1的第i个字符相同
        *                   3.2 s1的前i个字符和s2的前j-1个字符能否构成s3的前i+j-1个字符，且s3的第i+j个字符是否与s2的第j个字符相同
        *                   注意：要避免数组越界的情况，所以会在代码中加以限制
        * */
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        //排除不可能情况
        if (n1+n2 != n3)
            return false;
        boolean f[][] = new boolean[n1+1][n2+1];
        f[0][0] = true;
        for(int i = 0; i <= n1; ++i){
            for (int j = 0; j <= n2; ++j){
                //利用 i>0, j>0是为了避免分解问题时产生数组越界的问题
                if (i > 0){
                    //分解问题的第一种情况
                    f[i][j] =  f[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                }
                if (j > 0){
                    //比上一步多了 f[i][j] || ... 是因为第二种情况如果不可能实现，但第一种情况可以实现，避免覆盖上一种情况的结果
                    f[i][j] = f[i][j] || (f[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
                }
            }
        }
        return f[n1][n2];
    }
}
