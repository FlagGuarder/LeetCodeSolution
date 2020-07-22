import java.lang.reflect.Array;
import java.util.*;

public class Solution20 {
/*    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        if (nums == null || nums.length<3)
            return Collections.emptyList();
        Set<List<Integer>> set = new LinkedHashSet<>();
        int target;
        for (int i = 0;i < n-2;i++){
            target = -nums[i];
            Map<Integer,Integer> map = new HashMap<>(n-i);
            for (int j = i+1;j < n;j++){
                int v = target - nums[j];
                Integer exist = map.get(v);
                if (exist != null){
                    List<Integer> list = Arrays.asList(nums[i],v,nums[j]);
                    list.sort(Comparator.naturalOrder());
                    set.add(list);
                }else
                    map.put(nums[j],nums[j]);
            }
        }
        return new ArrayList<>(set);
    }*/

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3 )
            return Collections.emptyList();
        Set<List<Integer>> set = new LinkedHashSet<>();
        int target;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0;i < n-2;i++){
            if (nums[i] > 0)
                break;
            target = -nums[i];
            int head = i+1;
            int tail = n-1;
            while (head < tail){
                if (nums[head] + nums[tail] == target){
                    List<Integer> list = Arrays.asList(nums[i], nums[head], nums[tail]);
                    list.sort(Comparator.naturalOrder());
                    set.add(list);
                    tail--;
                }else if (nums[head] + nums[tail] < target)
                    head++;
                else
                    tail--;
            }

        }

        return new ArrayList<>(set);
    }
}
