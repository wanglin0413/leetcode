public class MaxGap {
    public int maximumGap(int[] nums) {
        if(nums.length <= 1) return 0;
        int max = 0;
        for(int each:nums){
            max = Math.max(max, each);
        }
        for(int exp = 1; max / exp >0; exp*=10){
            radix_sort(nums, exp);
        }
        int gap = 0;
        int before = nums[0];
        for(int each: nums){
            gap = Math.max(gap, each - before);
            before = each;
        }
        return gap;
    }
    //先比较个位数，排序；再比较十位数，排序；直至最高位；也叫bucket sort
    private void radix_sort(int[] nums, int exp) {
        int n = nums.length;
        int[] result = new int[n];
        int[] count = new int[10];
        for (int each: nums){
            count[each/exp % 10]++;
        }
        for(int i =1; i < 10; i++){
            count[i]+=count[i-1];
        }
        for(int i = n-1; i >=0; i--){
            result[--count[nums[i] / exp % 10]] = nums[i];
        }
        for (int i =0; i < n; i++){
            nums[i] = result[i];
        }
    }
}
