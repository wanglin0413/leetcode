package medium;

import java.util.Arrays;

public class CombineSum {
    public int combinationSum4(int[] nums, int target) {
        //comb[target] = sum(comb[target - nums[i]])
//        if(target == 0){
//            return 1;
//        }
//        int result = 0;
//        for(int each:nums){
//            if(target >= each){
//                result += combinationSum4(nums, target - each);
//            }
//        }
//        return result;
        //首先写成递归的算法，然后用dp方法来记录已经计算过的，避免重复计算
        //dp的概念是什么？？
        int[] subTarget = new int[target+1];
        for(int i =0 ; i < target + 1; i ++){
            subTarget[i] = -1;
        }
        return helper(nums, target, subTarget);
    }

    private int helper(int[] nums, int target, int[] subTarget) {
        System.out.println(Arrays.toString(subTarget));
        if(subTarget[target] != -1)return subTarget[target];
        if(target == 0)return 1;
        int result = 0;
        for(int each:nums){
            if(target >= each){
                result += helper(nums, target -each, subTarget);
            }
        }
        subTarget[target] = result;
        return result;
    }

    public static void main(String[] args) {
        CombineSum cs = new CombineSum();
        int[] test = new int[]{1,2,3};
        System.out.println(cs.combinationSum4(test, 4));
    }
}
