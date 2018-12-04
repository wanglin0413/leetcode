package easy;

public class RemoveDup {
    public int removeDuplicates(int[] nums) {
        int currentI = 0;
        int nextI = 1;
        int n = nums.length;
        while (nextI < n){
            if(nums[currentI] == nums[nextI]){
                nextI++;
            }else {
                swap(nums, currentI+1, nextI);
                currentI++;
                nextI++;
            }
        }
        return currentI+1;
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
