package medium;

public class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {
			int endIndex = 0;
			int curIndex = 1;
			boolean two = false;
			while (curIndex < nums.length){
				if(nums[curIndex] == nums[endIndex]){
					if (two){
						curIndex++;
					}else {
						nums[++endIndex] = nums[curIndex++];
						two = true;
					}
				}else {
					nums[++endIndex] = nums[curIndex++];
					two = false;
				}
			}
			return ++endIndex;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
		RemoveDuplicates removeDuplicates = new RemoveDuplicates();
		System.out.println(removeDuplicates.removeDuplicates(nums));
	}

}
