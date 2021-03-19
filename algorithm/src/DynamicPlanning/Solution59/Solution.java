package DynamicPlanning.Solution59;

public class Solution {

    /*
    *  题目描述：一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

        机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

        问总共有多少条不同的路径？

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/unique-paths

    *
    *
    * 解题思路：经典的动态规划题，利用已有的计算结果，计算下一步的的结果，减少计算量，实现性能提升。
    *
    * 这道题目说明了只有两种移动方式，那么到达某一个点的位置按道理最多只有两种可能，从左边的位置点
    *
    * 向右移动，或者从上边的位置点向下移动。那么到达当前点的路径数量，就是分别到达这两个点的路径之和。
    *
    * 特殊情况：在第一行，或者第一列的位置点，能够到达的方式只有一种，第一行只能由左边的点向右移动，
    *
    * 第一列只能由上边的点向下移动得到，所以这些点的到达方式均为1.
    *
    * 得到上述规律，我们可以构建动态规划方程。
    *
    |  a[0][0] = 1
    |  a[i][0] = 1; ( 0 < i < m)
    |  a[0][j] = 1; ( 0 < j < n)
    |  a[r][c] = a[r-1][c] + a[r][c-1]; ( 1 <= r < m, 1 <= c < n)
    */

    public static int uniquePaths(int m, int n) {

        int[][] dfs = new int[m][n];
        dfs[0][0] = 1;
        // col
        for (int i=1;i<n; i++){
            dfs[0][i] = 1;
        }
        for (int j = 1; j < m; j++){
            dfs[j][0] = 1;
        }
        for (int row = 1; row < m; row++){
            for (int col = 1; col < n; col++){
                dfs[row][col] = dfs[row][col-1] + dfs[row-1][col];
            }
        }
        return dfs[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }

}
