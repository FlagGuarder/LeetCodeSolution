package Array.Solution2578;

import java.util.Arrays;

public class Solution {
    public static int splitNum(int num) {
        Integer integer = new Integer(num);
        String numStr = integer.toString();
        char[] charArray = numStr.toCharArray();
        Arrays.sort(charArray);
        Integer num1 = 0;
        Integer num2 = 0;
        int i = 0;
        if (charArray.length%2 == 1){
            num1 = Integer.valueOf(charArray[i]-48);
            i++;
        }
        for (;i < charArray.length;i = i+2){
            num1 = num1 * 10 + charArray[i]-48;
            num2 = num2 * 10 + charArray[i+1]-48;
        }

        return num1+num2;
    }

    public static void main(String[] args) {
        int i = splitNum(4325);

        int i1 = splitNum(687);
        int i2 =0;
    }
}
