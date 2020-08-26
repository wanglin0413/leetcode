package easy;

import java.util.Arrays;

public class DegreeOfArray {
    public int findShortestSubArray(int[] nums) {
        int max = 0;
        for(int num : nums){
            if(num > max)max = num;
        }
        int[] count = new int[max + 1];
        int[] start = new int[max + 1];
        Arrays.fill(start, -1);
        int[] end = new int[50000];
        for(int i = 0; i < nums.length; i++){
            count[nums[i]]++;
            if(start[nums[i]] == -1)start[nums[i]] = i;
            end[nums[i]] = i;
        }
        int maxCount = 0;
        int minSub = Integer.MAX_VALUE;
        for(int i = 0; i < count.length; i++){
            if(count[i] > maxCount){
                minSub = end[i] - start[i] + 1;
                maxCount = count[i];
            }else if(count[i] == maxCount){
                minSub = Math.min(minSub, end[i] - start[i] + 1);
            }
        }
        return minSub;
    }

    public static void main(String[] args) {
        DegreeOfArray da = new DegreeOfArray();
        int[] nums = new int[]{0};
        System.out.println(da.findShortestSubArray(nums));
    }
}
