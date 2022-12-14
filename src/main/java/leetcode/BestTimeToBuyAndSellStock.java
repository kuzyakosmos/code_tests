package leetcode;

@LeetcodeNumber(number = 121)
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int buy = 100000;
        int sell = 0;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
                sell = prices[i];
            }
            if (prices[i] > sell) {
                sell = prices[i];
                profit = Math.max(profit, sell - buy);
            }
        }
        return profit;
    }
}
