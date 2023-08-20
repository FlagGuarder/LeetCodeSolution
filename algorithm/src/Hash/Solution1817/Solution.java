package Hash.Solution1817;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer,Integer> userTime = new HashMap();
        HashMap<Integer, Set<Integer>> userLog = new HashMap();
        for (int[] operateItem : logs){
            int userId = operateItem[0];
            int time = operateItem[1];
            Set<Integer> logItem = userLog.get(userId);
            if (logItem==null){
                HashSet logSet = new HashSet();
                logSet.add(time);
                userLog.put(userId,logSet);
                userTime.put(userId,1);
            }else {
                if (logItem.contains(time)){
                    // 该时间有过操作记录

                }else {
                    //无操作记录
                    logItem.add(time);
                    userTime.put(userId,userTime.get(userId)+1);
                }
            }
        }

        int[] answers = new int[k];
        for (Map.Entry<Integer,Integer>entry : userTime.entrySet()){
            Integer time = entry.getValue();
            if (time!=null && time <= k){
                answers[time-1]++;
            }

        }

        return answers;
    }

    public static void main(String[] args) {
        int[][] input = {{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}};
        int[] ints = findingUsersActiveMinutes(input,5);
        int i = 0;
    }
}
