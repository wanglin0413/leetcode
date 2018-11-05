

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by wanglin03 on 2017/9/26.
 */
public class Square {
    int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; i++)dp[i] = Integer.MAX_VALUE;
        System.out.println(Arrays.toString(dp));
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
                System.out.println(Arrays.toString(dp));
            }
        }
        return dp[n];
    }
    int numSquares2(int n){
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(0);
        while (dp.size() <= n){
            int m = dp.size();
            int val = Integer.MAX_VALUE;
            for(int i = 1; i*i <= m; i++){
                val = Math.min(val, dp.get(m - i*i) + 1);
                System.out.print(val + " ");
            }
            dp.add(val);
            System.out.println(dp.toString() + " " + dp.size());

        }
        return dp.get(n);
    }

    public static void main(String[] args){
        Square square = new Square();
        int answer = square.numSquares(10);
        int answer2 = square.numSquares2(10);
        System.out.print(answer);
    }
}
