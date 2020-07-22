public class Solution4
{
    /*
    *测试用例
    * 符号开头：".dfdf*","*dfs."
    * 字母开头："dfs*"，"dfsdf."*/
    public static boolean isMatch(String s, String p) {
        boolean ans;
        if (s == null || p == null)
            return false;
        int lp = p.length();
        int ls = s.length();

        //寸长匹配状态，s串的前i个与p串前j个的匹配状态
        boolean dp[][] = new boolean[ls+1][lp+1];
        dp[0][0] = true;
        //预处理
        for (int i = 0; i < p.length(); i++){
            if (p.charAt(i) == '*' && dp[0][i-1]){
                dp[0][i+1] = true;
            }
        }



        for (int i = 0; i < ls; i++){
            for (int j = 0; j < lp; j++){
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)){
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*'){
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.'){
                        dp[i+1][j+1] = dp[i+1][j-1];
                    }else if(p.charAt(j-1) == s.charAt(i) || p.charAt(j-1) == '.'){
                        dp[i+1][j+1] = (dp[i+1][j-1] || dp[i+1][j] || dp[i][j+1]);
                    }
                }
            }
        }
        ans = dp[ls][lp];

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aaa",".*"));
    }
}
