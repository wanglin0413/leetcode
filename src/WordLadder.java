import java.util.*;


/**
 * Created by wanglin03 on 2017/10/25.
 */
public class WordLadder {

//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        int diff = compareTwo(beginWord,endWord);
//        if(diff == 1) return 1;
//        Map<String, Map> map = new HashMap<>();
//        return findEnd(beginWord,endWord,wordList, map,shortest);
//    }
//
//    private int findEnd(String beginWord, String endWord, List<String> wordList, Set<Integer> used, Integer shortest) {
//        for(String word:wordList){
//            if(!used.contains(word)){
//                int diff = compareTwo(beginWord, word);
//                if(diff == 1 && word.equals(endWord)){
//                    return shortest+1;
//                }
//            }
//
//        }        return 0;
//    }
//
//
//    private int compareTwo(String beginWord, String endWord) {
//        int diff = 0;
//        for(int i = 0; i < beginWord.length(); i++){
//            if(beginWord.charAt(i) != endWord.charAt(i)) diff++;
//        }
//        return diff;
//    }
}
