package Solution41;

import java.awt.*;
import java.util.Arrays;
//题目：两个数组交集 11
public class Solution {
    public static int[] intersect(int[] num1, int[] num2){
        //为两个数组进行排序
        Arrays.sort(num1);
        Arrays.sort(num2);
        int n = num1.length > num2.length ? num1.length : num2.length;
        int[] ans = new int[n];
        int index1=0,index2=0;
        int i = 0;
        //遍历两个数组，找出集合的交集
        while (index1 < num1.length && index2 < num2.length){
            //找到了,就直接存储ans数组，然后移动两个数组的下标
            if (num1[index1] == num2[index2]){
                ans[i++] = num1[index1];
                index1++; index2++;
            }else {
                //如果两个下标对应的数据不同，因为已经排好序了，移动值较小的下标
                if (num1[index1] > num2[index2])
                    index2++;
                else
                    index1++;
            }
        }
        //截取存有交集的部分，也可以使用linkList，就可以不用这个部分。
        return Arrays.copyOfRange(ans,0,i);
     }

    public static void main(String[] args) {
        int [] num1 = {4,9,5};
        int[] num2 = {9,4,9,8,4};
        int[] ans = intersect(num1,num2);
        for (int i : ans)
            System.out.printf(i+" ");
    }
}
