import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Solution23 {
    public int numRabbits(int[] answers) {
        int ans = 0;
        int len = answers.length;
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < len; i++){
            if (answers[i] == 0)
                ans++;
            else
            set.add(answers[i]);
        }
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()){
            ans += it.next()+1;
        }

        return ans;
    }

}
