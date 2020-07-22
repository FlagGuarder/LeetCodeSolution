public class Solution2 {
    public static int reverse(int x) {
        /*
        * 测试用例：
        * （输入数字为一位--8）
        * 输入位数为奇数--343
        * 输入位数为偶数--4243
        * 输入数字为0结尾*/
        int result = 0;
        int temp;
        //处理0结尾数字

        while (x!=0) {
            temp = x % 10;
            if(result > Integer.MAX_VALUE/10 || result == Integer.MAX_VALUE/10 && temp>=7){
                return 0;
            }
            if (result < Integer.MIN_VALUE/10 || result == Integer.MIN_VALUE/10 && temp<-8)
                return 0;
            result = result * 10 + temp;
            x /= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(900000));
    }
}
