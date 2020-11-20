package medium;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> resultMap = new HashMap<>();
        for(String each : strs){
            int[] numbers = new int[26];
            for(char eachChar : each.toCharArray()){
                numbers[eachChar - 'a']++;
            }
            int key = Arrays.hashCode(numbers);
            resultMap.putIfAbsent(key, new ArrayList<String>());
            resultMap.get(key).add(each);
        }
        return new ArrayList<>(resultMap.values());
    }
}
