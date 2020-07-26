package dfs.Solution52;

public class Solution {
    //329. Longest Increasing Path in a Matrix  矩阵中的最长递增路径
    //创建一个用于上下左右移动的方向数组
    public int direct[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    int rows,columns;
    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        //处理数据异常情况
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        //获取数据的行数和列数
        rows = matrix.length;
        columns = matrix[0].length;
        //创建记忆数组，用于保存当前数组可达的最长距离，因为有递增的规律在，所以不会再次遍历到已经访问到的点，同时每个点可达的最长距离是固定的
        //所以我们可以将已经计算的每个点可达的最长距离
        int memory[][] = new int[rows][columns];
        //深度搜索每个位置可达的最长路径
        for (int i = 0; i < rows; ++i){
            for (int j = 0; j < columns; ++j){
                ans = Math.max(ans, dfs(matrix, memory, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int[][] memory, int i, int j) {
        //如果值不为0，及已经计算过该位置可达的最长路径，可直接返回
        if (memory[i][j] != 0)
            return memory[i][j];
        int row,column;
        ++memory[i][j];
        //分别深度遍历上下左右四个位置符合条件的可达最长路径
        for (int [] dir : direct){
            row = i + dir[0];
            column = j + dir[1];
            if (0 <= row && rows > row && 0 <= column && columns > column && matrix[row][column] > matrix[i][j])
                memory[i][j] = Math.max(memory[i][j],dfs(matrix,memory,row,column)+1);
        }
        //返回从（i，j）位置出发，可达的最长路径。
        return memory[i][j];
    }
}
