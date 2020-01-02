package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        //sliding window思路，j指示window的起始，
        // 如果当前字符在window中，则window起始后移
        // 如果当前字符在window前，则window起始不变
        // max为最大窗口长度
        if(s.length() <= 1)return s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0,j = 0; i <s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-j+1);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubString lss  = new LongestSubString();
        System.out.println(lss.lengthOfLongestSubstring("abcabcbbabcd"));
    }
}
