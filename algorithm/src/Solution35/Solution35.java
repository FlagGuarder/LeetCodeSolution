package Solution35;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Solution35 {
    public int countCharacters(String[] words, String chars) {
        int ans = 0;
        if (chars.length() == 0 && words.length == 0)
            return ans;
        HashMap<Character,Integer> map = new LinkedHashMap<>();
        Integer value;
        for (int i = 0; i < chars.length(); i++){
            value = map.get(chars.charAt(i));
            if (value == null)
                map.put(chars.charAt(i),1);
            else
                map.replace(chars.charAt(i),value+1);
        }
        HashMap<Character,Integer> temp;
        Boolean sign;
        for (int i = 0; i < words.length; i++){
            temp = new LinkedHashMap<>(map); sign = true;

            for (int j = 0; j < words[i].length(); j++){
                Integer n = temp.get(words[i].charAt(j));
                if (n != null && n != 0){
                    temp.replace(words[i].charAt(j),n-1);
                }else
                    sign = false;
            }
            if (sign)
                ans += words[i].length();
        }

        return ans;
    }
}
