
public class Solution5 {
    public static  int maxArea(int[] height) {
        /*
        * 解题思路：
        * 第一种：最垃圾的，双重循环，存储最大结果，之后与最大结果比较
        * */
        int max_area = 0;
        int l_index,r_index;
        if (height.length<=1)
            return -1;
        l_index = 0;

        r_index = height.length-1;
        while (l_index < r_index){
            int h = Integer.min(height[l_index],height[r_index]);
            max_area = Integer.max(max_area , h * (r_index-l_index));
            if (height[l_index] < height[r_index]){
                l_index++;
            }else {
                r_index--;
            }
        }


        return max_area;
    }

    public static void main(String[] args) {
        int a[] = {1,8,6,2,5,4,8,3,7};
        int res = maxArea(a);
        System.out.println(res);
    }
}
