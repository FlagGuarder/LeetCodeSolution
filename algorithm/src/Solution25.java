public class Solution25 {
/* 递归解法
    private int coinChange(int idxCoin, int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (idxCoin < coins.length && amount > 0) {
            int maxVal = amount / coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x++) {
                if (amount >= x * coins[idxCoin]) {
                    int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                    if (res != -1)
                        minCost = Math.min(minCost, res + x);
                }
            }
            return (minCost == Integer.MAX_VALUE)? -1: minCost;
        }
        return -1;
    }*/

    public int coinChange(int[] coins, int amount) {
        if (amount < 1)
            return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    public int coinChange(int[] coins, int amount, int count[]){
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        if (count[amount-1] != 0)
            return count[amount-1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins){
            int res =coinChange(coins, amount-coin, count);
            if (res >= 0 && res < min)
                min = res + 1;
        }
        count[amount-1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[amount-1];
    }

}
