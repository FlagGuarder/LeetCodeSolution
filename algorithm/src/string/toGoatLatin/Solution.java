package string.toGoatLatin;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        toGoatLatin("I speak Goat Latin");
    }

    public static String toGoatLatin(String sentence) {
        String[] wordArray = sentence.split(" ");
        HashSet<Character> characterHashSet = new HashSet() {
            {
                add('A');
                add('I');
                add('E');
                add('O');
                add('U');
                add('a');
                add('i');
                add('e');
                add('o');
                add('u');
            }
        };
        if (wordArray.length==0)
            return "";
        StringBuffer resultStrBuilder = new StringBuffer();
        for (int i = 0; i < wordArray.length; i++){
            char c = wordArray[i].charAt(0);
            if (characterHashSet.contains(c)){
                resultStrBuilder.append(wordArray[i]).append("ma");
            }else {
                resultStrBuilder.append(wordArray[i].substring(1)).append(wordArray[i].charAt(0)).append("ma");
            }
            for (int j = 0; j <=i; j++){
                resultStrBuilder.append("a");
            }
            resultStrBuilder.append(" ");
        }
        return resultStrBuilder.toString().trim();
    }
}
