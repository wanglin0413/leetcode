package medium;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >=0 && nums[i] >= nums[i+1])i--;
        if (i >= 0){
            int index  = findSmallestGreaterIndex(nums, i);
            //交换i， index
            int tmp = nums[i];
            nums[i] = nums[index];
            nums[index] = tmp;
            //i后面的序列，reverse
            reverse(nums, i+1);
            return;
        }
        reverse(nums, 0);
    }

    private void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while (i < j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    //从后往前，找到第一个比curIndex大的就可以
    private int findSmallestGreaterIndex(int[] nums, int curIndex) {
        int result = nums.length - 1;
        while (result > curIndex){
            if(nums[result] > nums[curIndex]){
                return result;
            }
            result--;
        }
        return result;
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] nums = new int[]{1,3,2};
        np.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
