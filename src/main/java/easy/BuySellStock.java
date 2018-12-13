package easy;

public class BuySellStock {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int each:prices){
            if(each < min) min = each;
            int profit = each - min;
            if(profit > maxProfit) maxProfit = profit;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BuySellStock bss = new BuySellStock();
        int[] testcase = new int[]{7,1,5,3,6,4};
        System.out.println(bss.maxProfit(testcase));
    }
}
