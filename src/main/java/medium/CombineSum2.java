package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombineSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> oneResult = new ArrayList<>();
        dynamicAdd(result, candidates, 0, oneResult, target);
        return result;
    }

    private void dynamicAdd(List<List<Integer>> result, int[] candidates, int start, List<Integer> oneResult, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(oneResult));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] <= target) {
                    oneResult.add(candidates[i]);
                    dynamicAdd(result, candidates, i + 1, oneResult, target - candidates[i]);
                    int poped = oneResult.remove(oneResult.size() - 1);
                    while (i+1 < candidates.length && candidates[i+1] == poped) {
                        i++;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        CombineSum2 sum = new CombineSum2();
        List<List<Integer>> result = sum.combinationSum2(candidates, target);
        System.out.println(result);
    }
}
