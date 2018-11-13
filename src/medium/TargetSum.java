package medium;

import java.util.Arrays;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        //way[S] = sum(way[S-each] + way[S+each])
        //二维数组，还需要index，why？求出nums从第一个开始到最后一个，或加或减，所有可能的结果
        //way[i][s] = way[i-1][s-nums[i] + way[i-1][s+nums[i]]

        int n = nums.length;
        int sum = 0;
        for(int each : nums){
            sum += each;
        }
        if(S > sum || S < -sum)return 0;
        //加上一个sum是为了不出现负索引
        //为什么不初始化为负数？因为有些格子走不到，表示没有这种可能，结果应该是0
        int[][] dp = new int[n+1][2*sum+1];
        dp[0][sum] =1;
        for(int i =1 ; i<= n; i++){
            for(int j = 0; j <= 2*sum; j++){
                //数是当前的那个数，所以用i-1
                int num = nums[i-1];
                int result = 0;
                if(j - num >= 0){
                    //和为前一个数的结果，因为dp的索引比num的索引大1，所以也是i-1，其实是对应的nus[i-1]的前一个
                    result+= dp[i-1][j - num];
                }
                if(j + num <= 2*sum){
                    result += dp[i-1][j+num];
                }
                dp[i][j] = result;
            }
        }
        for(int[] each : dp){
            System.out.println(Arrays.toString(each));
        }

        return dp[n][S+sum];
    }



    public static void main(String[] args) {
        int[] test = new int[]{1,1,1,1,1};
        TargetSum ts = new TargetSum();
        System.out.println(ts.findTargetSumWays(test, 3));
    }
}
