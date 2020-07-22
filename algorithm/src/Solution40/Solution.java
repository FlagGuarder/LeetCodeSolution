package Solution40;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int index = 0;
            String s = in.nextLine();
            while (true){
                if (index >= s.length())
                    break;
                if (s.charAt(index)=='8') {
                    s = s.substring(0, index);
                    break;
                }
                else
                    index++;
            }
            if (s.length()<11)
                System.out.println("No");
            else
                System.out.println("YES");


        }
    }
}
