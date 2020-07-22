public class Solution11 {
    /*二维数组查找*/
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean ans;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length; int cols = matrix[0].length;
        int row = 0; int col = cols - 1;
        while (row < rows && col >= 0){
            if (matrix[row][col] == target){
                return true;
            }else {
                if (matrix[row][col] > target){
                    col--;
                }else
                    row++;
            }
        }
        return false;

    }
}
