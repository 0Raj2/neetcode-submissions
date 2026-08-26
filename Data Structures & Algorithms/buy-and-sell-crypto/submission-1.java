class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int curProfit = prices[i] - mini;
            maxProfit = Math.max(maxProfit, curProfit);

            mini = Math.min(mini, prices[i]);
        }
        return maxProfit;
    }
}
