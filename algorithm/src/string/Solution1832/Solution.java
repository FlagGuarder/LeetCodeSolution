package string.Solution1832;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> chSet = new HashSet<>();
        for (char ch : sentence.toCharArray()){
            chSet.add(ch);
            if (chSet.size()==26){
                return true;
            }
        }
        return false;
    }
}
