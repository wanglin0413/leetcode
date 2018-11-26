package medium;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int index = 0;
        int index0=0;
        int index2 = nums.length - 1;
        while (index <= index2  && index0 < nums.length && index < nums.length && index2 >=0){
            if(nums[index] == 2){
                swap(nums, index, index2);
                index2 --;
            }else if(nums[index] == 0){
                if(index != index0) swap(nums, index, index0);
                index0++;
                index++;
            }else {
                index++;
            }
        }
    }

    private void swap(int[] nums, int index, int index2) {
        int temp = nums[index];
        nums[index] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        SortColors sc = new SortColors();
        int[] test = new int[]{2,0,2,1,1,0};
        sc.sortColors(test);
        System.out.println(Arrays.toString(test));
    }
}
