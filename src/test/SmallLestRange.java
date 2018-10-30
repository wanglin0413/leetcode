package test;

import java.util.Arrays;

public class SmallLestRange {
    public int smallestRangeII(int[] A, int K) {
        if(A.length <= 1) return 0;
        Arrays.sort(A);
        int max = A[A.length - 1] - K;
        int min = A[0] + K;
        int result = Integer.MAX_VALUE;
        for(int i = 1 ; i < A.length ; i++){
            //对任意相邻的两个元素，A[i] <A[j], A[i]+K,A[j] -K 是subset of A[i] - K, A[j]+K
            int min2 = A[i] - K;
            //不用考虑A[j-1] -K这种情况，而加上一个K，也不可能是min，所以只需要判断是否大于当前max
            int max1 = A[i -1] + K;
            int curmin  = Math.min(min, min2);
            int curmax = Math.max(max1, max);
            result = Math.min(result, curmax - curmin);
        }
            return Math.min(result, A[A.length - 1] - A[0]);
    }
}
