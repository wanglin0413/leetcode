package easy;

import java.util.HashMap;
import java.util.Map;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> count = new HashMap<>();
        StringBuilder word = new StringBuilder();
        for(int i = 0; i < paragraph.length(); i++){
            if(Character.isLetter(paragraph.charAt(i))){
                if(Character.isUpperCase(paragraph.charAt(i))){
                    word.append(Character.toLowerCase(paragraph.charAt(i)));
                }else {
                    word.append(paragraph.charAt(i));
                }
            }else if(word.length() > 0) {
                count.put(word.toString(), count.getOrDefault(word.toString(), 0)+1);
                word = new StringBuilder();
            }
        }
        if(word.length() > 0){
            count.put(word.toString(), count.getOrDefault(word.toString(), 0)+1);
        }
        for(String ban : banned){
            count.put(ban, 0);
        }
        String result = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String paragraph = "Bob";
        String[] banned = new String[]{};
        MostCommonWord mcw = new MostCommonWord();
        System.out.println(mcw.mostCommonWord(paragraph, banned));
    }
}
