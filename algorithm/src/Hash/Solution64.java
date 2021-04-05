package Hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Solution64 {
    /*
    *   思路 ：
    *       本题需要的是计算森林中兔子的最少数量，题目中兔子会告诉我们其余同种颜色的兔子的具体数量，怎么计算最小的总数呢？
    *       其余兔子剩余数量相同的数据，代表着这是一种，或者多种颜色兔子的集合
    *       我们可以发现，对于提供的数据中，设剩余兔子数量（k），m+1 >= n（m为数据中其余兔子剩余数量，n为m在数据中出现的次数)
    *       ，我们可以把它们看作是同一种颜色的，这样计算的结果会是最少的
    *       例如如果给出的数据是3，3，会出现两种情况：
    *       1.两只兔子是同一颜色的，这时候总的兔子数量只有本身，加上其余三只兔子，即3+1=4
    *       2.两只兔子颜色不同，假设一种为蓝色，一种为红色，这时候兔子总数为红色兔子加上剩余的3只红色兔子和蓝色兔子加上其余三只
    *       兔子总和，即(1+3) + (1+3) = 8，总共8只兔子。
    *       当m+1 < n时，
    *       这时候最少肯定有 k 种颜色的兔子。
    *       k会出现两种情况，n%(m+1) != 0 时，k= n/(m+1) +1
    *                     n %(m+1) ==0 时，k= n/(m+1)
    *       每种兔子的数量为m+1,即有 k * （m+1）只兔子。
    *       例如给出的数据是 4，4，4，4，4，4， 这时候 6%(4+1)!=0
    *       兔子最少种类数 k = 6/(4+1) + 1 = 2
    *       最少兔子数量为 2 * 5 =10
    *
    *       以上内容可以计算所有剩余数量相同的数据所代表着的最少兔子数量，而问题是要计算整个森林的最少兔子数，我们只需要遍历一边数据
    *       统计一下，每个其余剩余数量出现的次数即可，然后将每个其余剩余数量所代表的最少兔子数量进行累加即可
    * */
    public static int numRabbits(int[] answers) {
        Integer result = 0;
        if (answers == null || answers.length==0){
            return 0;
        }
        Map<Integer,Integer> sameNumMap = new HashMap<>();
        for (int i = 0; i < answers.length; i++){
            int item = answers[i];
            Integer num = sameNumMap.get(item);
            if (num == null){
                sameNumMap.put(item,1);
            }else {
                sameNumMap.put(item,num+1);
            }
        }
        Set<Integer> keySet = sameNumMap.keySet();
        for (Iterator<Integer> it = keySet.iterator(); it.hasNext();){
            Integer key = it.next();
            Integer value = sameNumMap.get(key);
            if (key == 0){
                result += value;
            }else {
                int c = value/(key+1);
                int k = value % (key+1);
                if(k != 0)
                    c = c + 1;
                result += ( c==0 ? 1 : c ) * (key+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int a[] = {1,0,1,0,0};
        System.out.println(numRabbits(a));;
    }
}
