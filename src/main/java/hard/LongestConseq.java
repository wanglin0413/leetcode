package hard;

import java.util.HashMap;
import java.util.Map;

public class LongestConseq {
    //可以使用并查集算法
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])) continue;
            int left = map.get(nums[i] - 1) != null ? map.get(nums[i] - 1) : 0;
            int right = map.get(nums[i] + 1) != null ? map.get(nums[i] + 1) : 0;
            int t = left + right + 1;
            map.put(nums[i], t);
            map.put(nums[i] - left, t);
            map.put(nums[i] + right, t);

        }
        int max = 0;
        for(int value : map.values()){
            max = Math.max(max, value);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestConseq lcq = new LongestConseq();
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(lcq.longestConsecutive(nums));
    }
}
