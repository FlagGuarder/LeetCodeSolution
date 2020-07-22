import java.util.LinkedList;
import java.util.Queue;

public class Solution19 {
    /*腐烂的橘子*/
    public static int orangesRotting(int[][] grid) {
        int R = grid.length; int C = grid[0].length;
        int count_fresh = 0;
        int n = 0;
        int ans = 0;
        Queue<int[]> queue = new LinkedList<int []>();

        for (int r = 0;r < R;r++){
            for (int c = 0;c < C;c++){
                if (grid[r][c] == 1)
                    count_fresh++;
                if (grid[r][c] == 2){

                    queue.add(new int[]{r,c});
                }
            }
        }
       /* System.out.println("R="+R+" C="+C);*/
        int r;
        int c;
        while(count_fresh > 0 && !queue.isEmpty()){
            ans++;
            n = queue.size();
            for (int i = 0;i < n;i++){
                int[] orange = queue.poll();
                r = orange[0];
                c = orange[1];
                if (r-1 >= 0 && grid[r-1][c] == 1){
                    grid[r-1][c] = 2;
                    count_fresh--;
                    queue.add(new int[]{r-1,c});
                }
                if (r+1 < R && grid[r+1][c] == 1){
                    grid[r+1][c] = 2;
                    count_fresh--;
                    queue.add(new int[]{r+1,c});
                }
                if (c-1 >= 0 && grid[r][c-1] == 1){
                    grid[r][c-1] = 2;
                    count_fresh--;
                    queue.add(new int[]{r,c-1});
                }
                if (c+1 < C && grid[r][c+1] == 1){
                    grid[r][c+1] = 2;
                    count_fresh--;
                    queue.add(new int[]{r,c+1});
                }

            }
        }
        /*System.out.println(count_fresh);
        System.out.println("ans="+ans);*/
        if (count_fresh > 0)
            return -1;


        return ans;
    }

    public static void main(String[] args) {
        orangesRotting(new int[][]{{1,2}});
    }
}
