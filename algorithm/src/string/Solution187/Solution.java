package string.Solution187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ansList = new ArrayList<>();
        if(s.length()<=10){
            return ansList;
        }
        HashMap<String,Integer> tempMap = new HashMap<String,Integer>();
        for(int i = 0; i <= s.length()-10; i++){
            String str = s.substring(i,i+10);
            if(tempMap.get(str)==null){
                tempMap.put(str,1);
            }else if(tempMap.get(str) >1){
                continue;
            }else{
                tempMap.put(str,tempMap.get(str)+1);
                ansList.add(str);
            }
        }

        return ansList;
    }
}


