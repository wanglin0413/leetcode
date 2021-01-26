package medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	//返回从n中选k个数
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> stack = new ArrayList<>();
		combineHelper(result, stack, n, 0, k);
		return result;
	}

	private void combineHelper(List<List<Integer>> result, List<Integer> stack, int n, int start, int k) {
		if(stack.size() == k){
			result.add(new ArrayList<>(stack));
			return;
		}
		for(int i = start; i < n; i++){
			stack.add(i);
			combineHelper(result, stack, n, start+1, k);
			stack.remove(stack.size() - 1);
		}

	}

	public List<List<Integer>> combine1(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> stack = new ArrayList<>();
		int begin = 0;
		int count = 0;
		int cur = 0;
		while (begin != n-k+1 || cur < n){
			//需要回退的情况：满了k个，这种情况已经遍历完
			while ((count == k || cur >= count+ n+1-k) && !stack.isEmpty()){
				cur = stack.remove(stack.size() - 1);
				count--;
			}
			cur++;
			if(stack.isEmpty())begin = cur;
			stack.add(cur);
			count++;
			if(count == k){
				result.add(new ArrayList<>(stack));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Combinations combinations = new Combinations();
		System.out.println(combinations.combine(6, 5));
	}

}
