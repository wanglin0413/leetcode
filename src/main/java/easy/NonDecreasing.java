package easy;

public class NonDecreasing {
    public boolean checkPossibility(int[] nums) {
        int nonDe = 0;
        for(int i =0; i < nums.length - 1; i++){
            if(nums[i] > nums[i + 1]){
                nonDe++;
                if(i > 0 && nums[i-1] > nums[i+1]){
                    nums[i+1] = nums[i];
                }
            }
            if(nonDe > 1)return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,2,3};
        NonDecreasing nd = new NonDecreasing();
        System.out.println(nd.checkPossibility(nums));
    }
}
