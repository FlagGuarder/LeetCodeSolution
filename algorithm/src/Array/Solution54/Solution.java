package Array.Solution54;

public class Solution {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        /*
        * 解题思路： 我们可以发现中间可以两朵花之间能插多少花取决于两朵花之间的空隙，我们用下面的例子来列举一下，发现规律，x代表两朵花之间的间隙，
        * y代表可以插入的花朵数量。
        *   x=1, y=0
        *   x=2, y=0
        *   x=3, y=1
        *   x=4, y=1
        *   x=5, y=2
        *   x=6, y=2
        *   x=7, y=3
        *   y = (x-2)/2   小数点后的数省略
        *   但要考虑到起点是没种花的话，第一个间隙的计算计算规则与上面不一致，第二是一样的，如果最后一个间隙，后面没有种花，规律也不一样，所以第一个间隙和
        *   最后一个间隙都要考虑其他情况。
        *   起点和终点没有种花的话，间隙可以种花的数量为
        *   y = (x - 2)/2 小数点后省略 (当花坛第一个位置没有种花，我们也可以第一个下标设置为-2，此时我们也可以同样使用y = (x-2)/2，如果最后一个位置没有种花，我们可以使用y = (x-2)/2)
        *
        *   每一个间隙所能种的花数量累加，判断是否满足题目的要求数量，可以用剪枝的思想，用题目要求的数量去减去每一个间隙，如果当前剩余数小于等于0
        *   既满足题目要求
        *
        * */

        int start = 0; int end = flowerbed.length;
        int temp = 0;
        if (n==0)
            return true;
        if (flowerbed[0] == 0)
            start = -2;

        for (int i = 0; i < end; i++){
            if (flowerbed[i]!=0){
                if(temp!=start){
                    // 计算间隙
                    int sub = temp - start - 2;
                    if (sub > 0){
                        // 有位置，进行计算
                        n -= sub/2;
                    }
                    start = temp;
                    if (n <= 0)
                        return true;
                    // 重置两个间隙的位置；

                }

            }
            if (i == end-1){
                // 遍历到花坛最后一个位置，做一下特殊处理，如果花坛的最后的一个位置没有种花，不会进行最后的计算，我们在这里进行计算。
                if (start != temp && flowerbed[i]!=1){
                    if (end+1 - start -2 > 0){
                        n -= (end+1 - start -2)/2;
                        if (n <= 0)
                            return true;
                    }

                }
            }
            temp++;
        }
        return false;

    }

    public static void main(String[] args) {
        int[] a = {1,0,0,0,1};
        int[] b = {1,0,1,0,1,0,1};
        System.out.printf(canPlaceFlowers(b,1)+"xxxx");
    }
}
