package hard;

public class MissingPositive {
    public int firstMissingPositive(int[] nums) {
        //缺的数最多是从1到nums.length+1
        for(int i = 0; i < nums.length; ++i){
            if (nums[i] <= 0) {
                //如果有负数，则不可能缺nums.length+1
                nums[i] = nums.length + 1;
            }
        }

        for(int i = 0; i < nums.length; ++i){
            //大于nums.length的，跳过；
            if (Math.abs(nums[i]) <= nums.length) {
                // 不大于nums.length的，将第num[i]个数变成负数
                if(nums[Math.abs(nums[i]) - 1] > 0)
                    nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        //从索引0开始，如果不是负数，说明这个数没有
        int i;
        for(i = 0; i < nums.length; ++i){
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        // 如果都是负数了，说明都有，则返回i+1
       return i+1;
    }

    public static void main(String[] args) {
        MissingPositive mp = new MissingPositive();
        int[] nums = new int[]{1,2,3};
        System.out.println(mp.firstMissingPositive(nums));
    }
}
