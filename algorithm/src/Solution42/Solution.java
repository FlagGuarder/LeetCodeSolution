package Solution42;

public class Solution {
    public static boolean isPalindrome(int x){
        //小于0，肯定不行 -121  ->  121-
        if (x < 0)
            return false;
        //0  -  9，肯定可以
        if (x < 10)
            return true;
        //两位数以上，解法一，整数化为字符数组，两个下标首尾开始校验
        String s = String.valueOf(x);
        int front=0,end=s.length()-1;
        while (front <= end){
            if (s.charAt(front) == s.charAt(end)) {
                front++;
                end--;
            }else
                return false;

        }


        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(45345345));
    }
}
