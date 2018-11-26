/**
 * Created by wanglin03 on 2017/9/26.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = 0;
        end:
        for(i = 0; i<nums.length-1; i++){
            for(j = i + 1; j <= nums.length-1;j++){
                if(nums[i] + nums[j] == target){
                    break end;
                }
            }
        }
        return new int[]{i,j};
    }

    public static void main(String[] args){
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[]{3,2,4};
        int[] answer = twoSum.twoSum(nums, 6);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}
