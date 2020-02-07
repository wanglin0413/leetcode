package hard;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSub {
    //先window end 往后，达到条件后，window start往后，不满足条件了，window end再往后
    public String minWindow(String s, String t) {
        Map<Character, Integer> wordCount = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            int count = wordCount.getOrDefault(t.charAt(i), 0);
            wordCount.put(t.charAt(i), count+1);
        }
        int count = t.length(), begin = 0, end = 0, windowLength = Integer.MAX_VALUE, head = 0;
        while(end < s.length()){
            Integer wordC = wordCount.get(s.charAt(end));
            if(wordC != null){
                wordCount.put(s.charAt(end), wordC-1);
                if(wordCount.get(s.charAt(end))>= 0)count--;
            }
            end++;
            while(count == 0){
                if(end - begin < windowLength){
                    windowLength = end - begin;
                    head = begin;
                }
                wordC = wordCount.get(s.charAt(begin));
                if(wordC != null){
                    wordCount.put(s.charAt(begin), wordC + 1);
                    if(wordCount.get(s.charAt(begin)) > 0)count++;
                }
                begin++;
            }
        }
        return windowLength == Integer.MAX_VALUE? "": s.substring(head,head+windowLength);
    }

    public static void main(String[] args) {
        MinWindowSub mws = new MinWindowSub();
        System.out.println(mws.minWindow("ADOBECODEBANC","ABC"));
    }
}
