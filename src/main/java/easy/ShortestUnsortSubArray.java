package easy;

import java.util.Arrays;

public class ShortestUnsortSubArray {
    public int findUnsortedSubarray(int[] nums) {
//        int[] sorted = Arrays.copyOf(nums,  nums.length);
//        Arrays.sort(sorted);
//        int begin = 0;
//        int end = nums.length -1;
//        while (begin < nums.length && nums[begin] == sorted[begin])begin++;
//        if(begin == end + 1)return 0;
//        while (nums[end] == sorted[end])end--;
//        return end - begin+1;
        if(nums.length <= 1) return 0;

        // Left Boundary of Unsorted Array
        int minInUnSortedPart = Integer.MAX_VALUE;

        // Right Boundary of Unsorted Array
        int maxInUnSortedPart = Integer.MIN_VALUE;

        for(int i=0;i<nums.length-1;i++) {
            if(nums[i] > nums[i+1]) { // means this item is not in the correct order position
                minInUnSortedPart = Math.min(minInUnSortedPart,nums[i+1]);
                maxInUnSortedPart = Math.max(maxInUnSortedPart,nums[i]);
            }
        }
        if(minInUnSortedPart == Integer.MAX_VALUE && maxInUnSortedPart == Integer.MIN_VALUE)  return 0; // Everything is good.

        int placeToPutMin = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] > minInUnSortedPart) {
                placeToPutMin = i;
                break;
            }
        }

        int placeToPutMax = 0;
        for(int i=nums.length -1;i>=0;i--) {
            if(nums[i] < maxInUnSortedPart) {
                placeToPutMax = i;
                break;
            }
        }

        return placeToPutMax - placeToPutMin + 1;
    }

    public static void main(String[] args) {
        ShortestUnsortSubArray susa = new ShortestUnsortSubArray();
        int[] nums = new int[]{1,3,5,2,4};
        System.out.println(susa.findUnsortedSubarray(nums));
    }
}
