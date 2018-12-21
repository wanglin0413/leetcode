package easy;

public class HouseRobber {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        int n = nums.length;
        cache[n-1] = nums[n-1];
        cache[n-2] = Math.max(nums[n-1], nums[n-2]);
        for(int i = n-3; i >= 0; i--){
            cache[i] = Math.max(cache[i+2] + nums[i], cache[i+1]);
        }
        return Math.max(cache[0], cache[1]);
    }


    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        int[] testcase = new int[]{1,2,7,9,1};
        System.out.println(hr.rob(testcase));
    }
}
