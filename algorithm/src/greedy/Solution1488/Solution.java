package greedy.Solution1488;

import java.util.*;

public class Solution {
    public int[] avoidFlood(int[] rains) {
        TreeSet<Integer> st = new TreeSet<>();
        int[] ans = new int[rains.length];
        Arrays.fill(ans,1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rains.length; i++){
            if (rains[i] == 0){
                st.add(i);
            }else {
                ans[i] = -1;
                if (map.containsKey(rains[i])){
                    Integer it = st.ceiling(map.get(rains[i]));
                    if (it == null)
                        return new int[0];
                    st.remove(it);
                    ans[it] = rains[i];
                }
                map.put(rains[i],i);
            }
        }
        return ans;
    }

}
