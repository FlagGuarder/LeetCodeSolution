public class Solution26 {
/*    public int maxProfit(int[] prices) {
        int ans = 0;
        int preIndex,lastIndex;
        if (prices == null || prices.length == 0)
            return -1;
        for (int i = 0; i < prices.length-2 ;i++){
            preIndex = i+1; lastIndex = prices.length-1;
            while (preIndex - 1 != lastIndex && preIndex - 2 != lastIndex){
                int temp = prices[lastIndex] > prices[preIndex] ? prices[lastIndex] : prices[preIndex];
                ans = (temp - prices[i]) > ans ? (temp - prices[i]) : ans;
                preIndex++;
                lastIndex--;
            }
        }

        return ans;
    }*/

    public int maxProfit(int[] prices) {
        int ans = 0;
        int last = 0;
        for (int i = 0; i < prices.length-1; i++){
            last = (0 > (last+prices[i+1]-prices[i]) ? 0 : (last+prices[i+1]-prices[i]));
            ans = last > ans ? last : ans;
        }
        return ans;
    }
}
