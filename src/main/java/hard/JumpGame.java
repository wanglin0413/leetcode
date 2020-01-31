package hard;

import java.util.Arrays;

public class JumpGame {
    public int jump(int[] nums) {
        int[] steps = new int[nums.length];
        Arrays.fill(steps, -1);
        steps[0]=0;
        int i = 0;
        while (i < nums.length-1){
            int maxSteps = nums[i];
            int nextI = i;
            int maxStep = 0;
            for(int j = 1; j <= maxSteps && i+j < nums.length; j++){
                if(steps[i+j] != -1){
                    steps[i+j] = Math.min(steps[i] + 1, steps[i+j]);
                }else {
                    steps[i+j] = steps[i] + 1;
                }
                if(nums[i+j] + j > maxStep){
                    maxStep = nums[i+j] + j;
                    nextI = i+j;
                }
            }
            i = nextI;
        }
        return steps[nums.length-1];
    }
    public int jump1(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int count = 0, farest = 0, maxRange = 0, n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            //表示前i个点，能跳到的最远的点
            maxRange = Math.max(maxRange, i + nums[i]);
            //记录跳到最远的点，所需要的步数
            if (i == farest) {
                count++;
                farest = maxRange;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        int[] nums = new int[]{2,3,1,1,4,1,1,1,1,5};
        System.out.println(jg.jump(nums));
        System.out.println(jg.jump1(nums));
    }
}
