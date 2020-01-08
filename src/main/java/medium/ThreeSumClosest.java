package medium;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int interval = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                int tmpInterval = Math.abs(sum - target);
                if(tmpInterval == 0)return target;
                if(tmpInterval < interval){
                    interval = tmpInterval;
                    result = sum;
                }
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosest tsc = new ThreeSumClosest();
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(tsc.threeSumClosest(nums, 1));
    }
}
