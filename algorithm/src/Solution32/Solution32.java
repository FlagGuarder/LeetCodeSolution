package Solution32;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution32 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        List<Integer> row = new LinkedList<>();
        List<Integer> cor = new LinkedList<>();
        if (matrix == null)
            return ans;
        int min;
        int max;
        for (int i = 0; i < matrix.length; i++){
            min = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] < min);
                    min = matrix[i][j];
            }
            row.add(min);
        }
        for (int j = 0; j < matrix[0].length; j++){
            max = Integer.MIN_VALUE;
            for (int i = 0; i < matrix.length; i++){
                if (matrix[i][j] > max)
                    max = matrix[i][j];

            }
            cor.add(max);
        }

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == row.get(i) && matrix[i][j] == cor.get(j)){
                    ans.add(matrix[i][j]);
                }
            }
        }

        return ans;
    }
}
