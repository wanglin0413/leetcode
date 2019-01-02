package easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        return _isIsomorphic(s, t) && isIsomorphic(t, s);
    }
    //可以利用char[256]模拟hashmap

    private boolean _isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        int n = s.length();
        for(int i = 0; i < n; i++){
            Character mapResult = map.get(s.charAt(i));
            if(mapResult == null){
                map.put(s.charAt(i), t.charAt(i));
            }else if(mapResult != t.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings is = new IsomorphicStrings();
        System.out.println(is.isIsomorphic("ab", "aa"));
    }
}
