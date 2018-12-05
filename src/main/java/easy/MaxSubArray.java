package easy;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int max = Integer.MIN_VALUE;
        for(int each : nums){
            sum+=each;
            if(sum > max) max=sum;
            if(sum < 0)sum=0;
        }
        return max;
    }
}
