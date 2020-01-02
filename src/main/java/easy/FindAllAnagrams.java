package easy;

import java.util.*;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0)return result;
        Map<Character,Integer> count = new HashMap<>();
        for(char each : p.toCharArray()){
            count.merge(each, 1, (a, b) -> a + b);
        }
        int start = 0;
        for (int i = 0 ;i < s.length(); i++){
            Integer count1 = count.get(s.charAt(i));
            if(count1 == null){
                for(int j = start; j < i; j++){
                    count.put(s.charAt(j), count.get(s.charAt(j))+1);
                }
                start = i+1;
            }else if(count1 == 0){
                count.put(s.charAt(start), count.get(s.charAt(start))+1);
                start++;
                i--;
            }else {
                count.put(s.charAt(i), count1-1);
                if(i - start + 1 == p.length()){
                    result.add(start);
                    count.put(s.charAt(start), count.get(s.charAt(start))+1);
                    start++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAllAnagrams faa = new FindAllAnagrams();
        System.out.println(faa.findAnagrams("cbaebabacd", "abc").toString());
    }
}
