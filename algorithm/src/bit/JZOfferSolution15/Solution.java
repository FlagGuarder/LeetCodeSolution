package bit.JZOfferSolution15;

public class Solution {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count = 0;
        int item = n;
        while (item != 0){
            count += item & 1;
            item = item >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(0b11111111111111111111111111111101);
    }
}
