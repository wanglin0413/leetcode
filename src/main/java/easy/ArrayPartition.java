package easy;

import java.util.Arrays;

public class ArrayPartition {

//    public int arrayPairSum(int[] nums) {
//        Arrays.sort(nums);
//        int result = 0;
//        for(int i =0; i < nums.length /2; i++){
//            result+=nums[i*2];
//        }
//        return result;
//    }

        public int arrayPairSum(int[] nums) {
        int[] l = new int[20001];

        for(int i = 0; i < nums.length; i++){
            l[nums[i] + 10000]++;
        }
        boolean odd = true;
        int result = 0;


        for(int i = 0; i < l.length; i++){
            while (l[i] > 0){
                if(odd){
                    result+=i-10000;
                    odd = !odd;
                }else {
                    odd = !odd;
                }
                l[i]--;
            }
        }
        return result;
    }

}
