package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> oneResult  = new ArrayList<>();
        dynamicAdd(result, candidates, 0, oneResult, target);
        return result;
    }

    private void dynamicAdd(List<List<Integer>> result, int[] candidates, int start, List<Integer> oneResult, int target) {
        if(target == 0){
            result.add(new ArrayList<>(oneResult));
        }else {
            for(int i = start; i < candidates.length; i++){
                if(candidates[i] <= target){
                    oneResult.add(candidates[i]);
                    dynamicAdd(result, candidates, i, oneResult, target - candidates[i]);
                    oneResult.remove(oneResult.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        CombinationSum sum = new CombinationSum();
        System.out.println(sum.combinationSum(candidates, target));
    }
}
