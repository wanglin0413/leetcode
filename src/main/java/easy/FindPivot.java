package easy;

public class FindPivot {
    public int pivotIndex(int[] nums) {
        if(nums.length ==0 || nums.length == 2)return -1;
        if(nums.length == 1)return 0;
        int leftSum = 0;
        int rightSum = 0;
        for(int i = 1; i < nums.length; i++){
            rightSum += nums[i];
        }
        if(leftSum == rightSum)return 0;
        for(int i =1; i < nums.length; i++){
            leftSum += nums[i-1];
            rightSum -= nums[i];
            if(leftSum == rightSum)return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-1,-1,-1,-1,0};
        FindPivot fp = new FindPivot();
        System.out.println(fp.pivotIndex(nums));
    }
}
