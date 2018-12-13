package easy;

public class BuySellStockII {
    public int maxProfit(int[] prices) {
        int curMin = Integer.MAX_VALUE;
        int profit=0, curMax=0;
        int n = prices.length;
        for(int each:prices){
            if(each < curMax){
                profit+=curMax - curMin;
                curMin = each;
                curMax = 0;
            }else if(each < curMin){
                curMin = each;
            }else if(each > curMax){
                curMax = each;
            }
        }
        if(curMax > curMin)profit+=curMax-curMin;
        return profit;
    }
    public static void main(String[] args) {
        BuySellStockII bss = new BuySellStockII();
        int[] testcase = new int[]{1,2,3,4,5};
        System.out.println(bss.maxProfit(testcase));
    }
}
