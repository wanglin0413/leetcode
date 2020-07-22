package easy;

import java.util.Arrays;

public class MisMatch {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        boolean[] set = new boolean[nums.length +1];
        Arrays.fill(set, false);
        for(int i = 0; i < nums.length; i++){
            if(!set[nums[i]]){
                set[nums[i]] = true;
            }else {
                result[0] = nums[i];
            }
        }
        for(int i =1; i < set.length; i++){
            if(!set[i])result[1] = i;
        }
        return result;
    }

    public static void main(String[] args) {
        MisMatch mm = new MisMatch();
        int[] nums = new int[]{8,7,3,5,3,6,1,4};
        System.out.println(Arrays.toString(mm.findErrorNums(nums)));
    }
}
