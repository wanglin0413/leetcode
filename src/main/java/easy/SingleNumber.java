package easy;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        int n = nums.length;
        for(int i = 1; i < n; i++){
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        int[]  testcase = new int[]{4,1,2,1,2};
        System.out.println(sn.singleNumber(testcase));
    }
}
