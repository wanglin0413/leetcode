package medium;

import java.util.Arrays;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int result = -1;
        while (low <= high){
            int mid = (low + high) / 2;
            if(target == nums[mid]){
                result = mid;
                break;
            }else if(target < nums[mid]){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        if(result == -1)return new int[]{-1,-1};
        int[] arrayResult = new int[]{-1, -1};
        low = high = result;
        while (low > 0){
            if(nums[--low] != target){
                low++;
                break;
            }
        }
        while (high < nums.length - 1){
            if(nums[++high] != target){
                high--;
                break;
            }
        }
        arrayResult[0] = low;
        arrayResult[1] = high;
        return arrayResult;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        SearchRange sr = new SearchRange();
        System.out.println(Arrays.toString(sr.searchRange(nums, 1)));
    }
}
