package medium;

import java.util.Arrays;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        // 动态规划概念理解---找到状态转移方程，某一状态由上一状态决定？？
        //先考虑简单情况，和最大连续子数组
        // 求出以i结尾的 和最大的连续子数组F[i]
        //F[i+1] = Max(F[i] + nums[i+1], nums[i+1])
        //最后求global max F[i]


        //积最大的情况，要考虑负数和零（维护Fmin[i] 和 Fmax[i])
        //Fmin[i+1] = Min(Fmax[i] * nums[i+1], Fmin[i]*nums[i+1), nums[i+1])
        //Fmax[i+1] = Max(Fmax[i] * nums[i+1], Fmin[i]*nums[i+1), nums[i+1])

//        int[] Fmin = new int[nums.length + 1];
//        int[] Fmax = new int[nums.length +1];
//        Fmin[1] = nums[0];
//        Fmax[1] = nums[0];
//        for(int i = 2; i <= nums.length ; i++){
//                Fmin[i] = Math.min(Math.min(Fmax[i-1] * nums[i-1], nums[i-1]), Fmin[i-1] * nums[i-1]);
//                Fmax[i] = Math.max(Math.max(Fmax[i-1] * nums[i-1], nums[i-1]), Fmin[i-1] * nums[i-1]);
//        }
//        int result = Integer.MIN_VALUE;
//        for(int i = 1; i <= nums.length; i++){
//            if(Fmax[i] > result) result = Fmax[i];
//        }
//        return result;

        int Fmin = nums[0];
        int Fmax = nums[0];
        int result = nums[0];
        for (int i = 1 ; i <= nums.length -1; i++) {
            int temp = Fmin;
            Fmin = Math.min(Math.min(Fmax * nums[i], nums[i]), Fmin * nums[i]);
            Fmax = Math.max(Math.max(Fmax * nums[i], nums[i]), temp * nums[i]);
            if(Fmax > result){
                result = Fmax;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxProduct mp = new MaxProduct();
        int[] test = new int[]{2, 3, -2, 4};
        System.out.println(mp.maxProduct(test));
    }
}
