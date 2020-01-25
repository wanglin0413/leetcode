package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatSubString {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(words.length == 0)return result;
        Map<String, Integer> wordCount = new HashMap<>();
        //每个word的数量
        for(String each : words){
            wordCount.put(each, wordCount.getOrDefault(each, 0) + 1);
        }
        Map<String, Integer> wordCountCopy = new HashMap<>();
        int wordLength = words[0].length();
        int wordsCount = words.length;
        int totalLength = wordLength*wordsCount;
        for(int i = 0; i < wordLength; i++){
            int starter = i;
            while (starter + totalLength <= s.length()){
                wordCountCopy.putAll(wordCount);
                int j = wordsCount;
                //从后往前匹配，如果中间某个失陪，则从头到中间该字符，一定都不对
                while (j != 0){
                    String curWord = s.substring(starter+wordLength*(j-1), starter+wordLength*j);
                    if(wordCountCopy.containsKey(curWord)){
                        int count = wordCountCopy.get(curWord);
                        if(count > 0){
                            wordCountCopy.put(curWord, count-1);
                            j--;
                        }else {
                            break;
                        }
                    }else {
                        break;
                    }
                }
                if(j == 0){
                    result.add(starter);
                    starter += wordLength;
                }else {
                    starter += wordLength*j;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        ConcatSubString css = new ConcatSubString();
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word","good","best","good"};
        System.out.println(css.findSubstring(s, words));
    }
}
