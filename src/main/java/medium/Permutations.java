package medium;

import java.util.*;

public class Permutations {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return result;
        Set<Integer> set =new HashSet<>();
        for(int each : nums){
            set.add(each);
        }
        addOnePermute(new ArrayList<>(), set);
        return result;
    }

    private void addOnePermute(List<Integer> oneResult,  Set<Integer> set) {
        if(set.isEmpty()){
            result.add(oneResult);
            return;
        }
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()){
            Integer one = it.next();
            List<Integer> newList = new ArrayList<>(oneResult);
            newList.add(one);
            Set<Integer> newSet = new HashSet<>(set);
            newSet.remove(one);
            addOnePermute(newList, newSet);
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = new int[]{1,2,3};
        System.out.println(permutations.permute(nums));
    }
}
