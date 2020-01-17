package medium;

public class SearchInRotateArray {
    public int search(int[] nums, int target) {
        return searchBinarayR(nums, 0, nums.length-1, target);
    }

    private int searchBinarayR(int[] nums, int low, int high, int target) {
        if(low > high)return -1;
        int mid = (low + high) / 2;
        if(nums[mid] == target)return mid;
        //说明前面是乱序的
        if(nums[low] > nums[mid]){
            if(nums[mid] < target && nums[high] >= target){
                return searchBinaray(nums, mid+1, high, target);
            }else {
                return searchBinarayR(nums, low, mid, target);
            }
        }else if(nums[mid] > nums[high]){//后半部分是乱序的
            if(nums[mid] > target && nums[low] <= target){
                return searchBinaray(nums, low, mid, target);
            }else {
                return searchBinarayR(nums, mid+1, high, target);
            }
        }else {//都不是乱序的
            if(nums[mid] > target){
                return searchBinaray(nums,  low,mid, target);
            }else {
                return searchBinaray(nums, mid+1,high, target);
            }
        }
    }

    private int searchBinaray(int[] nums, int low, int high, int target) {
        if(low > high)return -1;
        int mid = (low + high) / 2;
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] < target){
            return searchBinaray(nums, mid+1, high,target);
        }else {
            return searchBinaray(nums, low, mid-1, target);
        }
    }

    public static void main(String[] args) {
        SearchInRotateArray sra = new SearchInRotateArray();
        int[] nums = new int[]{1,3,5};
        System.out.println(sra.search(nums, 2));
    }
}
