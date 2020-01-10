package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 4)return result;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if(i != 0 && nums[i] == nums[i-1])continue;
            for(int j = i+1; j < nums.length -2; j++){
                if(j != i+1 && nums[j] == nums[j-1])continue;
                int low = j+1, high = nums.length -1;
                int sum = target - nums[i] - nums[j];
                while (low < high){
                    if(sum == nums[low] + nums[high]){
                        List<Integer> oneResult = new ArrayList<>();
                        oneResult.add(nums[i]);
                        oneResult.add(nums[j]);
                        oneResult.add(nums[low]);
                        oneResult.add(nums[high]);
                        result.add(oneResult);
                        while (low < high && nums[low+1] == nums[low])low++;
                        while (low < high && nums[high-1] == nums[high])high--;
                        low++;
                        high--;
                    }else if(sum < nums[low] + nums[high]){
                        high--;
                    }else {
                        low++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,-5,-2,-2,-4,0,1,-2};
        FourSum fs = new FourSum();
        System.out.println(fs.fourSum(nums, -9));
    }
}
