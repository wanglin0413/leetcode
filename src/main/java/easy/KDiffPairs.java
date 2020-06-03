package easy;

import java.util.Arrays;

public class KDiffPairs {
    public int findPairs(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        int firstIndex = 0;
        int secondIndex = 1;
        while (firstIndex < nums.length -1){
            while (secondIndex < nums.length && nums[secondIndex] - nums[firstIndex] < k){
                secondIndex++;
            }
            if(secondIndex < nums.length && nums[secondIndex] - nums[firstIndex] == k){
                count++;
                int add2 = nums[secondIndex];
                while (secondIndex < nums.length && nums[secondIndex] == add2){
                    secondIndex++;
                }
            }
            int add1 = nums[firstIndex];
            while (firstIndex < nums.length && nums[firstIndex] == add1){
                firstIndex++;
            }
            if(secondIndex <= firstIndex){
                secondIndex = firstIndex+1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        KDiffPairs kdp = new KDiffPairs();
        int[] nums = new int[]{1,3,1,5,4};
        System.out.println(kdp.findPairs(nums, 0));
    }
}
