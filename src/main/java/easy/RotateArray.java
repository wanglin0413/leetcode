package easy;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        //更便于理解的解决方案是 将0到n-k-1 reverse，将n-k 到n-1 reverse，然后将0到n-1reverse即可
        int n = nums.length;
        int cur = n -1 - k % n;
        int tmp = nums[cur];
        nums[cur] = -1;
        int times = n;
        while (times > 0){
            int nexIndex = (cur +k)%n;
            if(nums[nexIndex] == -1){
                nums[nexIndex] = tmp;
                cur = (nexIndex+1)%n;
                tmp = nums[cur];
                if(times > 1)nums[cur] = -1;
                times--;
            }else {
                int inTmp = nums[nexIndex];
                nums[nexIndex] = tmp;
                tmp = inTmp;
                cur = nexIndex;
                times--;
            }
        }
    }

    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int[] testcase = new int[]{1,2,3,4,5,6,7};
        ra.rotate(testcase, 2);
        System.out.println(Arrays.toString(testcase));
    }
}
