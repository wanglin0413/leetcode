package easy;

public class LongestSubIncreasing {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        int count = 1;
        int max = 0;
        int pre = nums[0];
        for(int i =1; i < nums.length; i++){
            if(nums[i] <= pre){
                max = Math.max(count, max);
                count = 1;
            }else {
                count++;
            }
            pre = nums[i];
        }
        return Math.max(max, count);
    }

    public static void main(String[] args) {
        LongestSubIncreasing lsi = new LongestSubIncreasing();
        int[] nums = new int[]{1,3,5,6,7};
        System.out.println(lsi.findLengthOfLCIS(nums));
    }
}
