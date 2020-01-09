package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombin {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0)return result;
        char[][] maps = new char[4][8];
        for (char[] eachline : maps) {
            Arrays.fill(eachline, ' ');
        }
        char cur = 'a';
        for (int i = 0; i < 8; i++) {
            int j = 3;
            if (i == 5 || i == 7) j = 4;
            for (int k = 0; k < j; k++) {
                maps[k][i] = cur;
                cur++;
            }
        }
        char[] oneResult = new char[digits.length()];
        letterCom(result, oneResult, 0, digits, maps);
        return result;
    }

    private void letterCom(List<String> result, char[] oneResult, int charIndex, String digits, char[][] maps) {
        if(charIndex >= digits.length()){
            result.add(new String(oneResult));
            return;
        }
        for(int row = 0; row < 4; row++){
            int column = digits.charAt(charIndex) - '2';
            if(maps[row][column] == ' ')return;
            oneResult[charIndex] = maps[row][column];
            letterCom(result, oneResult, charIndex+1, digits, maps);
        }
    }

    public static void main(String[] args) {
        LetterCombin lc = new LetterCombin();
        System.out.println(lc.letterCombinations("27"));
    }
}
