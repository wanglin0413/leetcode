package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        Map<Character,Integer> map = new HashMap<>();
        char[] row1 = new char[]{'Q','W','E','R','T','Y','U','I','O','P'};
        char[] row2 = new char[]{'A','S','D','F','G','H','J','K','L'};
        char[] row3 = new char[]{'Z','X','C','V','B','N','M'};
        for(char each : row1){
            map.put(each, 1);
        }
        for(char each : row2){
            map.put(each,2);
        }
        for(char each : row3){
            map.put(each,3);
        }
        List<String> result = new ArrayList<>();
        for(String each : words){
            if(inOneRow(each, map)){
                result.add(each);
            }
        }
        String[] sre = new String[result.size()];
        for(int i=0; i< sre.length; i++){
            sre[i] = result.get(i);
        }
        return sre;
    }

    boolean inOneRow(String word, Map<Character, Integer> map){
        Integer row = map.get(word.charAt(0));
        if(row == null ){
            row = map.get((char)(word.charAt(0) - 32));
        }
        int rowi = row;
        for(char each : word.toCharArray()){
            if((map.get(each) == null && map.get((char)(each-32)) != rowi) || (map.get(each)!=null &&map.get(each) != rowi )){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        KeyboardRow kr = new KeyboardRow();
        kr.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
    }
}
