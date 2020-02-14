package hard;

public class BestSellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp1 = new int[n];
        int hold1 = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            hold1 = Math.min(hold1, prices[i]);
            // dp1表示到i这天，最大的利润
            dp1[i] = Math.max(prices[i] - hold1, 0);
        }

        int holdSell = Integer.MIN_VALUE;
        int totalProfit = 0;
        int profit2 = 0;
        for(int i = n - 1; i >= 0; i--) {
            // 倒着看，表示i到最后，最大的利润
            holdSell = Math.max(holdSell, prices[i]);
            profit2 = Math.max(profit2, holdSell - prices[i]);
            totalProfit = Math.max(totalProfit, profit2 + dp1[i]);

        }
        return totalProfit;
    }

    public static void main(String[] args) {
        BestSellStock bestSellStock = new BestSellStock();
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        System.out.println(bestSellStock.maxProfit(prices));
    }
}
