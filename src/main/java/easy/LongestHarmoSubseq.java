package easy;

import java.util.Arrays;

public class LongestHarmoSubseq {
    public int findLHS(int[] nums) {
        if(nums.length == 0)return 0;
        Arrays.sort(nums);
        int maxCount = 0;
        int firstCount = 1;
        int secondCount = 0;
        int curNum = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == curNum){
                firstCount++;
            }else if(nums[i] == curNum +1){
                secondCount++;
            }else{
                if(firstCount != 0 && secondCount != 0){
                    maxCount = Math.max(maxCount, firstCount + secondCount);
                }
                if(nums[i] - curNum == 2){
                    curNum = curNum +1;
                    firstCount = secondCount;
                    secondCount = 1;
                }else {
                    curNum = nums[i];
                    firstCount = 1;
                    secondCount = 0;
                }
            }
        }
        if(firstCount != 0 && secondCount != 0){
            maxCount = Math.max(maxCount, firstCount + secondCount);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        LongestHarmoSubseq lhs = new LongestHarmoSubseq();
        int[] nums = new int[]{1,1,1,1,3,3,4};
        System.out.println(lhs.findLHS(nums));
    }
}
