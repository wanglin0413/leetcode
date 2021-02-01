package medium;

public class SearchRotateArray {

	public boolean search(int[] nums, int target) {
		return searchBinarayR(nums, 0, nums.length-1, target);
	}

	private boolean searchBinarayR(int[] nums, int low, int high, int target) {
		if(low > high)return false;
		int mid = (low + high) / 2;
		if(nums[mid] == target)return true;
		//说明前面是乱序的
		if(nums[low] == nums[mid]){
			return searchBinarayR(nums, low, mid-1, target) || searchBinarayR(nums, mid+1, high, target);
		}
		else if (nums[low] > nums[mid]){
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

	private boolean searchBinaray(int[] nums, int low, int high, int target) {
		if(low > high)return false;
		int mid = (low + high) / 2;
		if(nums[mid] == target){
			return true;
		}else if(nums[mid] < target){
			return searchBinaray(nums, mid+1, high,target);
		}else {
			return searchBinaray(nums, low, mid-1, target);
		}
	}

	public static void main(String[] args) {
		SearchRotateArray sra = new SearchRotateArray();
		int[] nums = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
		System.out.println(sra.search(nums, 2));
	}


}
