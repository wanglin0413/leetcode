package medium;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //并不是所有的算法，都跟数学有关，都跟某个算法模式（如dp）有关
        //其实有一半的算法题，只是将繁琐的、重复的步骤提炼出来，用程序语言表述出来
        //这才是算法或是编程的基本功，先实现、再分析时间复杂度、再寻找优化的余地
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0)break;
            if(i >= 1 && nums[i] == nums[i-1])continue;
            int j = i+1, k = nums.length -1,sum = 0-nums[i];
            while ( j < k){
                if(nums[j] + nums[k] == sum){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    result.add(tmp);
                    while (j < k && nums[j+1] == nums[j])j++;
                    while (k > j && nums[k] == nums[k-1])k--;
                    j++;k--;
                }else if(nums[j] + nums[k] < sum){
                    j++;
                }else k--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(ts.threeSum(nums));
    }
}
