package test;

import java.util.Arrays;

public class SmallestRange {
    public int smallestRangeI(int[] A, int K) {
        int min=A[0];
        int max = A[A.length-1];
        for(int i : A){
            if(i > max)max = i;
            if(i < min)min = i;
        }
        if(max - min > K*2){
            return max-min-2*K;
        }else {
            return 0;
        }
    }
}
