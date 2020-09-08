package easy;

import java.util.*;

public class LongestWord {
    public String longestWord(String[] words) {
        Map<Integer, List<String>> map = new HashMap<>();
        for(String word : words){
            int len = word.length();
            map.computeIfAbsent(len, k -> new ArrayList<>());
            map.get(len).add(word);
        }
        int length = 1;
        Set<String> set = new HashSet<>();
        List<String> curWords = map.get(length);
        for(String each : curWords){
            set.add(each);
        }
        length++;
        while (true){
            if(map.get(length) !=null){
                curWords = map.get(length);
                boolean find = false;
                for(String each : curWords){
                    if(set.contains(each.substring(0, each.length() -1))){
                        set.add(each);
                        find = true;
                    }
                }
                if(!find)break;
                length++;
            }else {
                break;
            }
        }
        curWords = map.get(length - 1);
        List<String> beixuan = new ArrayList<>();
        for(String each : curWords){
           if(set.contains(each)){
               beixuan.add(each);
           }
        }
        Collections.sort(beixuan);
        return beixuan.get(0);
    }

    public static void main(String[] args) {
        LongestWord lw = new LongestWord();
        String[] words = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(lw.longestWord(words));
    }
}
