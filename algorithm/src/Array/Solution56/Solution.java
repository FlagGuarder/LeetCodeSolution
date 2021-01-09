package Array.Solution56;
public class Solution {
    public static int[] rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }

        return nums;
    }

    public static int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }


    public static void main(String[] args) {
        int [] nums = {-1,-100,3,99};
        int[] result = rotate(nums,2);
        int i = 0;
    }
}
