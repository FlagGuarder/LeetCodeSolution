package DynamicPlanning.Solution49;

public class Solution {
    //64. 最小路径和
    public int minPathSum(int[][] grid) {
        //异常数据处理
        if (grid == null)
            return -1;
        //获取二维数组的行数和列数
        int n = grid.length;
        int m = grid[0].length;
        int res[][] = new int[n][m];
        //动态规划数组初始化
        res[0][0] = grid[0][0];
        //最左列，及列下标为0的位置，只能由上一同一列的位置到达，所以可以先计算0列的最小路径 （ j = 0， 1 <= i < n)
        for (int i = 1 ; i < n; ++i)
            res[i][0] = res[i-1][0] + grid[i][0];
        //最上一行，行下标为0的数据同理（ i = 0， 1 <= j < m)
        for (int j = 1; j < m; ++j)
            res[0][j] = res[0][j-1] + grid[0][j];
        /*
        * 动态规划思路：
        *   除了特殊情况（上述已经进行处理），其他位置的最小路径可以看成上一行同一列的最小路径加上当前的值与同一行前一列的最小路径的值加上当前的值中的较小值
        *   写成数学式子为： res[i][j] = res[i-1][j] < res[i][j-1] ? res[i-1][j] + grid[i][j] : res[i][j-1] + grid[i][j] （1 <= i < n, 1 <= j <m）;
        *   计算出动态规划数组res，可以直接获取res[n-1][m-1]即可到达右下角的最小路径。
        * */
        for (int i = 1; i < n; ++i){
            for (int j = 1; j < m; ++j){
                res[i][j] = res[i-1][j] < res[i][j-1] ? res[i-1][j] + grid[i][j] : res[i][j-1] + grid[i][j];
            }
        }
        return res[n-1][m-1];
    }
}
