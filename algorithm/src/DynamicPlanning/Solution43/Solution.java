package DynamicPlanning.Solution43;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode题目编号120：三角形最小路径和
public class Solution {
    /*
    * 本题动态规划讲解：
    * 本题的三角形其实可以看作一个数组的上三角或者下三角，这个采用下三角比较合适
    * 本题的特殊情况的是当前点是顶点还有每行最左边和最右边的点，顶点无须计算，
    * 最左边只有上一行最左边的点可以到达，直接是上一行同一列的最小路径加上当前点的值即可，
    * f[i][0] = f[i-1][0] + triangle.get(i).get(0);
    * 最右边同理
    * f[i][i] = f[i-1][i-1] + triangle.get(i).get(i);
    * 处于中间的点，有两种情况，分配时是当前位置上一行的左边和右边，因为我们看成如下下三角
    *    *
    *    * *
    *    * * *
    * 所以，可能到达当前位置[i][j]的点只有，[i-1][j-1]和[i-1][j]两个点，所以到达[i][j]的最小路径的是当前点的值
    * 加上上述两个点路径中较小路径，得到动态规划公式：
    *   f[i][j] = Math.min(f[i-1][j-1], f[i-1][j]) + triangle.get(i).get(j);
    *
    * */
    public static int minimumTotal(List<List<Integer>> triangle){
        //三角形行数
        int n = triangle.size();
        //动态规划中，存储部分计算结果数组
        int[][] f = new int[n][n];
        //f[i][j]表示到达i行j列最小的路径，因为之前的上一层的最小路径已经计算完成，只需要在当前所在位置，选择与上层连接最小的路径即可
        f[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < n; ++i ){
            //特殊情况一：最左边只有上一层最左边可以到达，无需选择
            f[i][0] = f[i-1][0] + triangle.get(i).get(0);
            //根据上述动态规划参数公式计算
            for (int j = 1; j < i; ++j)
                f[i][j] = Math.min(f[i-1][j-1], f[i-1][j]) + triangle.get(i).get(j);

            //特殊情况二：当前行最右边只能由上一层最右边计算得到。
            f[i][i] = f[i-1][i-1] + triangle.get(i).get(i);
        }
        int ans = f[n-1][0];
        for (int i = 1; i < n; ++i)
            ans = Math.min(ans,f[n-1][i]);
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(6,5,7));
        list.add(Arrays.asList(4,1,8,3));
        System.out.println(minimumTotal(list));
    }
}
