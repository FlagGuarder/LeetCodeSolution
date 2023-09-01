package greedy.Solution1754.Solution134;

import java.util.Arrays;

public class Solution14 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        long gasCount = Arrays.stream(gas).count();
        long costCount = Arrays.stream(cost).count();
        int length = gas.length;
        if (gasCount < costCount)
            return -1;
        for (int i = 0; i < length; i++){
            int tempGas = 0;
            for (int j = i, k = 0; k < length; k++,j = (j + 1) % length){
                tempGas = tempGas + gas[j];
                tempGas = tempGas - cost[j];
                if (tempGas < 0){
                    break;
                }
            }
            if (tempGas >= 0){
                return i;
            }
        }
        return -1;
    }
}
