package easy;

import java.util.*;

public class ArrayIntersection {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return new int[0];
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int each : nums1){
            map.merge(each, 1, (a, b) -> a + b);
        }
        for(int each:nums2){
            if(map.get(each)!= null && map.get(each) > 0){
                result.add(each);
                map.put(each, map.get(each) -1);
            }
        }
        int[] resultInt = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            resultInt[i] = result.get(i);
        }
        return resultInt;
    }
}
