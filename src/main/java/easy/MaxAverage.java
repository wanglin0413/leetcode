package easy;

public class MaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length < k){
            double sum = 0;
            int count = 0;
            for(int each : nums){
                sum+=each;
                count++;
            }
            return sum/count;
        }
        double maxSum = 0;
        for(int i = 0; i < k; i++){
            maxSum+=nums[i];
        }
        double curSum = maxSum;
        for(int j = k; j < nums.length; j++){
            curSum += nums[j];
            curSum -= nums[j-k];
            if(curSum > maxSum){
                maxSum = curSum;
            }
        }
        return maxSum/k;
    }

    public static void main(String[] args) {
        MaxAverage ma = new MaxAverage();
        int[] nums = new int[]{1,12,-5,-6,50,3};
        System.out.println(ma.findMaxAverage(nums, 4));
    }
}
