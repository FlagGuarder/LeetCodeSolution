package DynamicPlanning.Solution22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
     char leftChar = '(';
    char rightChar = ')';
    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        generateAll(new char[2*n],0,resultList);
        return resultList;
    }

    void generateAll(char[] current,int pos,List<String> result){
        if (pos == current.length){
            if (valid(current)){
                result.add(new String(current));
            }
        }else {
            current[pos] = leftChar;
            generateAll(current,pos+1,result);
            current[pos] = rightChar;
            generateAll(current,pos+1,result);
        }

    }

    Boolean valid(char[] current){
        int balance=0;
        for (int i=0; i < current.length; i++){
            if (current[i]==rightChar){
                if (--balance < 0){
                    return Boolean.FALSE;
                }
            }
            if (current[i]==leftChar){
                balance++;
            }
        }
        return balance==0;
    }

}
