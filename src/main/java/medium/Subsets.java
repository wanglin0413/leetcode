package medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		subsetsHelper(result, new ArrayList<>(), nums, 0);
		return result;
	}

	private void subsetsHelper(List<List<Integer>> result, List<Integer> numStack, int[] nums,
		int start) {
		result.add(new ArrayList<>(numStack));
			for(int i = start; i < nums.length; i++){
				numStack.add(nums[i]);
				subsetsHelper(result, numStack, nums, i + 1);
				numStack.remove(numStack.size() - 1);
			}
	}

	public static void main(String[] args) {
		Subsets subsets = new Subsets();
		int[] nums = new int[]{1,2, 3};
		System.out.println(subsets.subsets(nums));
	}

}
