package easy;

public class SearchInsertPos {
    //找到最后一个小于target的index+1
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n;
        int mid=(low + high) >> 1;
        while (low < high){
            mid = (low + high) >> 1;
            if(target == nums[mid])return mid;
            if(target < nums[mid] ){
                high = mid;
            }else {
                low = mid+1;
            }
        }
        return nums[mid] > target? mid : mid+1;
    }



    public static void main(String[] args) {
        SearchInsertPos sip = new SearchInsertPos();
        int[] test = new int[]{1, 3, 5, 6};
        System.out.println(sip.searchInsert(test, 5));
    }
}
