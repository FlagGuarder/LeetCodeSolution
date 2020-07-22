package Array.Solution48;

public class Solution {
    //剑指 Offer 11. 旋转数组的最小数字  时间击败100%，内存1击败00%
    public static int minArray(int[] numbers) {
        /*
        * 思路：思路简单，因为题目描述"把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。"，我们可以理解为只是前部分少数
        * 数组旋转，所以从后面开始遍历可以实现算法优化。
        * 如：[3,4,5,1,2]，所示，我们只需要从后面开始遍历，找到一个数比他前面的数小即可（因为题目说了是有序数组），比如这里的1，就是答案。
        * 为什么是这样呢？思考一下，一开始数组是一个有序升序数组（[3,4,5,1,2]），我们截取了前面的部分（[1,2]），转移到后面去（[3,4,5,1,2]），
        * 而转移部分的第一个元素就是最小的元素（比如1），原本数组被分为两部分（[3,4,5],[1,2]），两部分的数组仍保持原有的升序特征，只有在他们的
        * 连接处的最小值1，会出现降序的情况。所以我们只要找到找到一个数比他前面的数小即可。
        *
        * 注意：我们要注意空数组的情况，避免数组越界。
        *
        *
        * */
        //数组长度
        int n = numbers.length;
        int index = n-1;
        if (n == 0)
            return -1;
        while (index > 0){
            if (numbers[index] < numbers[index-1])
                return numbers[index];
            --index;
        }
        return numbers[index];

    }

    public static void main(String[] args) {
        int[] a = {};
        System.out.println(minArray(a));
    }
}
