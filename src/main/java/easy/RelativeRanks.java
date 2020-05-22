package easy;

import java.util.Arrays;

public class RelativeRanks {
    //题目说nums最多不超过10000个，因此用空间换时间
    //建一个哈希数组，长度为nums中的最大值，根据nums的值，将nums的索引哈希到数组中，nums数据在哈希数组中升序排列
    //逆序遍历哈希数组，相当于按排名访问nums，根据nums的索引，将排名填到string数组对应索引处
    public String[] findRelativeRanks(int[] nums) {
        String[] name = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
        int[] ordered = Arrays.copyOf(nums, nums.length);
        Arrays.sort(ordered);
        String[] result = new String[nums.length];
        for(int i = 0; i < result.length; i++){
            int rank = result.length - binarySearch(ordered, nums[i]) - 1;
            if(rank < 3){
                result[i] = name[rank];
            }else {
                result[i] = rank + 1 + "";
            }
        }
        return result;
    }

    private int binarySearch(int[] ordered, int num) {
       int low = 0;
       int high = ordered.length;
       while (low <= high){
           int mid = (low + high) >> 1;
           if(ordered[mid] == num)return mid;
           if(ordered[mid] > num){
               high = mid;
           }else {
               low = mid+1;
           }
       }
       return -1;
    }

    public static void main(String[] args) {
        RelativeRanks rr = new RelativeRanks();
        int[] nums = new int[]{5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(rr.findRelativeRanks(nums)));
    }
}
