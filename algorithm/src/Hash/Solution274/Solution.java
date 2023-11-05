package Hash.Solution274;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
        public static int hIndex(int[] citations) {
            Map<Integer,Integer> dict = new HashMap<>();
            for(int citation : citations){
                if(dict.get(citation)!=null){
                    dict.put(citation,dict.get(citation)+1);
                }else{
                    dict.put(citation,1);
                }
            }
            int ans = 0;
            for(Map.Entry<Integer,Integer> entry : dict.entrySet()){
                if(entry.getValue() >= entry.getKey()){
                    ans = ans < entry.getKey() ? entry.getKey() : ans;
                }
            }
            String s = new String();
            return ans;
        }

    public static void main(String[] args) {
        int[] ints = {1, 2};
        hIndex(ints);
    }

}
