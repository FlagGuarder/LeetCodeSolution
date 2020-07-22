public class Solution1 {

    //最大回文串
    public static String longestPalindrome(String s) {
        int max_len=0;
        int end_index=0;
        int length = s.length();
        boolean a[][] = new boolean[length][length];
        if (length == 0)
            return "";
        for (int i = 0;i<length;i++){
            //一位数一定是回文串
            a[i][i]=true;
            int j =0 ;
            //不能重复
            for(; j<i; j++){
                //最右边与最左边相同，且中间为回文，则大串为回文
                if(s.charAt(i) == s.charAt(j) && ((i-j<2) || ((i-j>=2) && a[j+1][i-1]))){
                    a[j][i] = true;
                    if (i-j+1>max_len){
                        max_len = i-j;
                        end_index = i;


                    }
                }
                else {
                    a[j][i] = false;
                }

            }



        }
        if (max_len == 0 ){
            return  s.substring(0,1);
        }

        //实际长度比max——len加一，
        return s.substring(end_index-max_len,end_index+1);

    }

    public static void main(String[] args) {
        String hello = longestPalindrome(new String("a"));
        System.out.println(hello);
    }
}
