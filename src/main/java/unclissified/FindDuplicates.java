package unclissified;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> result = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int index = 0; index <nums.length; index++){
            if(result.contains(nums[index])){
                list.add(nums[index]);
            }else {
                result.add(nums[index]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        FindDuplicates find = new FindDuplicates();
        int[] nums = new int[]{39,31,8,14,14,38,5,15,29,49,18,6,30,47,8,35,2,17,6,10,29,46,41,48,1,36,5,28,46,39,7,47,18,42,17,11,36,45,21,33,24,10,24,50,25,16,9,12,11,25};
        System.out.println(find.findDuplicates(nums));
    }

}
