package DynamicPlanning.Solution22;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        addWithBackTrack(resultList,new StringBuilder(),0,0,n);
        return resultList;
    }

    void addWithBackTrack(List<String> resultList,StringBuilder builder,int open,int close,int max){
        if (builder.length()==2*max){
            resultList.add(builder.toString());
            return;
        }
        if (open<max){
            builder.append('(');
            addWithBackTrack(resultList,builder,open+1,close,max);
            builder.deleteCharAt(builder.length()-1);
        }
        if (close < open){
            builder.append(')');
            addWithBackTrack(resultList,builder,open,close+1,max);
            builder.deleteCharAt(builder.length()-1);
        }
    }
}
