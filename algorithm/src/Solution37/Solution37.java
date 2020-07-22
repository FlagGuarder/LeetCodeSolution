package Solution37;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution37 {
    private HashMap<Character,Integer> tMap = new HashMap<Character,Integer>();
    private HashMap<Character,Integer> sMap = new HashMap<Character,Integer>();
    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0;i < tLen;i++){
            char c = t.charAt(i);
            tMap.put(c,tMap.getOrDefault(c,0)+1);
        }
        int l = 0; int r = -1;
        int ansL = -1; int ansR = -1;
        int len = Integer.MAX_VALUE;
        int sLen = s.length();
        while (r < sLen){
            r++;
            if (r < sLen && tMap.containsKey(s.charAt(r))){
                sMap.put(s.charAt(r),sMap.getOrDefault(s.charAt(r),0)+1);
            }
            while (check() && l<=r){
                if (r - l + 1 < len){
                    len = r - l +1;
                    ansL = l;
                    ansR = l + len;
                }
                if (tMap.containsKey(s.charAt(l))){
                    sMap.put(s.charAt(l),sMap.getOrDefault(s.charAt(l),0) - 1);
                }
                ++l;
            }
        }


        return ansL == -1 ? "" : s.substring(ansL,ansR);
    }
    public boolean check(){
        Iterator iterator = tMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            Character key = (Character) entry.getKey();
            Integer value = (Integer) entry.getValue();
            if (sMap.getOrDefault(key,0) < value){
                return false;
            }

        }
        return true;
    }

}
