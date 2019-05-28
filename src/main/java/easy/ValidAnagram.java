package easy;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        for(char each: s.toCharArray()){
            count.merge(each, 1, (a, b) -> a + b);
        }
        for(char each:t.toCharArray()){
            count.merge(each, -1,(a,b)->a +b);
        }
        for(Integer value:count.values()){
            if(value != 0)return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        System.out.println(va.isAnagram("rat","cat"));
    }
}
