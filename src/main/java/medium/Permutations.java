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

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> numList = new ArrayList<>();
        for(int each : nums){
            numList.add(each);
        }
        return permuteInner(numList);

    }

    private List<List<Integer>> permuteInner(List<Integer> nums) {
        if(nums.size() == 1){
            List<List<Integer>> oneNumList = new ArrayList<>();
            oneNumList.add(nums);
            return oneNumList;
        }
        List<List<Integer>> innerResult = new ArrayList<>();
        Integer cur = null;

        for(Integer each : nums){
            if(!each.equals(cur)){
                List<Integer> remained = new ArrayList<>(nums);
                remained.remove(each);
                List<List<Integer>> oneList = permuteInner(remained);
                for(List<Integer> eachList : oneList){
                    eachList.add(0, each);
                    innerResult.add(eachList);
                    cur = each;
                }
            }
        }
        return innerResult;
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = new int[]{1,1,2};
//        System.out.println(permutations.permute(nums));
        System.out.println(permutations.permuteUnique(nums));
    }
}
