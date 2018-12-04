package easy;

import java.util.Arrays;

public class RemoveEle {
    public int removeElement(int[] nums, int val) {
        //lIndex指向从左边开始第一个等于val的值
        int lIndex = 0;
        //rIndex指向从右边开始第一个不等于val的位置
        int rIndex = nums.length - 1;
        while (lIndex <= rIndex){
            if (nums[lIndex] == val){
                while (rIndex > lIndex && nums[rIndex] == val){
                    rIndex--;
                }
                if(rIndex ==lIndex)return rIndex;
                if(rIndex > lIndex)swap(nums, lIndex, rIndex--);
            }else {
                lIndex++;
            }
        }
        return lIndex;
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    public static void main(String[] args) {
        RemoveEle re = new RemoveEle();
        int[] test = new int[]{5,5};
        System.out.println(re.removeElement(test, 5));
        System.out.println(Arrays.toString(test));
    }

}
