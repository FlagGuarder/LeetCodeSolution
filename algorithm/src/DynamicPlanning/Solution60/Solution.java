package DynamicPlanning.Solution60;
    /*
    *  题目描述：一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

       机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

       现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

       来源：力扣（LeetCode）
       链接：https://leetcode-cn.com/problems/unique-paths-ii

    *
    *
    * 解题思路：本题是本项目的’不同路径‘的升级题目，加了一点点限制条件，有些点的位置会存在障碍物
    *
    * 而无法直接到达，这道题目同样只有两种移动方式，那么到达某一个点的位置按道理最多只有两种可能，
    *
    * 从左边的位置点向右移动，或者从上边的位置点向下移动。那么到达当前点的路径数量，就是分别到达这
    *
    * 两个点的路径之和。
    *
    * 特殊情况：在第一行，或者第一列的位置点，能够到达的方式只有一种，第一行只能由左边的点向右移动，
    *
    * 第一列只能由上边的点向下移动得到，且第一行，或者第一列上的点的上一个点如果是不能到达的，后续的
    *
    * 点尽管不存在障碍物，也是同样无法到达的。
    *
    * 本题解部分过程利用了位运算
    *
    * 得到上述规律，我们可以构建动态规划方程。
    *
    |  dfs[0][0] = obstacleGrid[0][0] ^ 1;  使用异或运算符，在原点时，只有当前点无障碍（即为0）时，才可到达
    |  dfs[i][0] = dfs[i-1][0] == 0 ? 0 : dfs[i-1][0] ^ obstacleGrid[i][0]; ( 0 < i < row)  如果前一个点是不可达，则后面都不可达，如果前面一个点可达，
    |  dfs[0][j] = dfs[0][j-1] == 0 ? 0 : dfs[0][j-1] ^ obstacleGrid[0][j];( 0 < j < col)  那么当前点是否可达取决于当前有无障碍的情况，当且仅当当前点无障碍的情况
    |  dfs[r][c] = obstacleGrid[r][c] == 1 ? 0 : dfs[r-1][c] + dfs[r][c-1]; 如果当前点有障碍，则不可达，反之则为上一步两个点的到达方式之和
    */

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int col = obstacleGrid[0].length;
        int row = obstacleGrid.length;
        int[][] dfs = new int[row][col];
        dfs[0][0] = obstacleGrid[0][0] ^ 1;
        if (dfs[0][0] == 0)
            return 0;
        for (int i = 1; i < row; i++){
            dfs[i][0] = dfs[i-1][0] == 0 ? 0 : dfs[i-1][0] ^ obstacleGrid[i][0];
        }
        for (int j = 1; j < col; j++){
            dfs[0][j] = dfs[0][j-1] == 0 ? 0 : dfs[0][j-1] ^ obstacleGrid[0][j];
        }
        for (int r = 1; r < row; r++){
            for (int c = 1; c < col; c++){
                dfs[r][c] = obstacleGrid[r][c] == 1 ? 0 : dfs[r-1][c] + dfs[r][c-1];
            }
        }
        return dfs[row-1][col-1];
    }

    public static void main(String[] args) {

    }
}
