package Array.ProjectionAreaof3DShapes;

public class Solution {
    public static int projectionArea(int[][] grid) {
        int[] xValue = new int[grid.length];
        int[] yValue = new int[grid[0].length];
        int result = 0;

        for (int x = 0; x < grid.length; x++){
            for (int y = 0; y < grid[0].length; y++){
                int value = grid[x][y];
                int xMax = Math.max(xValue[x], grid[x][y]);
                int yMax = Math.max(yValue[y],grid[x][y]);
                xValue[x] = xMax;
                yValue[y]=yMax;
                if (value!=0)
                    result +=1;
            }
        }
        for (int i = 0; i < xValue.length; i++){
            result += xValue[i];
        }
        for (int i = 0; i < yValue.length; i++){
            result += yValue[i];
        }
        return result;
    }

    public static void main(String[] args) {
        projectionArea(new int[][]{{1,2},{3,4}});
    }
}
