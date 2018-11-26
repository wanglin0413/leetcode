package hard;

import java.util.Arrays;
import java.util.HashMap;

public class RussionDoll {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0)return 0;
        long[] capEnve = new long[envelopes.length];
        for(int i = 0 ; i < envelopes.length ; i++){
            capEnve[i] =  ((long)envelopes[i][0] << 32) + (long)envelopes[i][1];
        }
        Arrays.sort(capEnve);

        int[] count = new int[envelopes.length];
        Arrays.fill(count,1);
        long mask = 0xffff;
        int max = 1;
        for(int i = 1; i < envelopes.length; i++){
            System.out.println("max : " + max);
            int curMax = 1;
           for(int j = i -1 ; j >=0; j--){
               if(capEnve[i] >> 32 > capEnve[j] >> 32 && (capEnve[i] & mask) > (capEnve[j] & mask)){
                   if(count[j]+1 >curMax){
                       curMax = count[j] + 1;
                   }
                   if(curMax > max){
                       max = curMax;
                       break;
                   }
               }
           }
            count[i] =curMax;

        }
        System.out.println(Arrays.toString(count));
        int result = 0;
        for(int each:count){
            if(each > result){
                result = each;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RussionDoll rd = new RussionDoll();
        int[][] test = new int[][]
                {{46,89},{50,53},{52,68},{72,45},{77,81}};
//                int[][] test = new int[][]
//                {{5,4},{6,4},{6,7},{2,3}};
        System.out.println("result = " + rd.maxEnvelopes(test));
    }
}
