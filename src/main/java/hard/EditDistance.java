package hard;

import java.util.Arrays;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] count = new int[word2.length() + 1][word1.length() + 1];
        for(int i = 0; i <= word1.length(); i++){
            count[0][i] = i;
        }
        for(int i = 1; i <= word2.length(); i++){
            count[i][0] = i;
        }
        for(int word1Index = 1; word1Index < word1.length()+1; word1Index++){
            for(int word2Index = 1; word2Index < word2.length() +1; word2Index++){
                if(word1.charAt(word1Index-1) == word2.charAt(word2Index-1)){
                    int tmp = Math.min(count[word2Index-1][word1Index-1], count[word2Index][word1Index-1]+1);
                    int min = Math.min(tmp, count[word2Index-1][word1Index]+1);
                    count[word2Index][word1Index] = min;
                }else {
                    int tmp = Math.min(count[word2Index-1][word1Index-1], count[word2Index][word1Index-1]);
                    int min = Math.min(tmp, count[word2Index-1][word1Index]);
                    count[word2Index][word1Index] = min + 1;
                }
            }
        }
        return count[word2.length()][word1.length()];
    }

    private int minDistance(char[] word1Chars, int word1Index, char[] word2Chars, int word2Index) {
        if(word1Index == word1Chars.length && word2Index < word2Chars.length){
            return word2Chars.length - word2Index;
        }else if(word2Index == word2Chars.length && word1Index < word1Chars.length){
            return word1Chars.length - word1Index;
        }else if(word1Index == word1Chars.length && word2Index == word2Chars.length){
            return 0;
        }
        if (word1Chars[word1Index] != word2Chars[word2Index]) {
            int removed = minDistance(word1Chars, word1Index+1, word2Chars, word2Index) + 1;
            int replaced = minDistance(word1Chars, word1Index+1, word2Chars, word2Index+1) + 1;
            int inserted = minDistance(word1Chars, word1Index, word2Chars, word2Index+1) + 1;
            if (replaced > removed) return Math.min(inserted, removed);
            return Math.min(inserted, replaced);
        }
        return minDistance(word1Chars, word1Index+1, word2Chars, word2Index+1);
    }

    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        System.out.println(ed.minDistance("zoologicoarchaeologist","zoogeologist"));
    }
}
