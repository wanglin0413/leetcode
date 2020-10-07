package easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCode {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> morseSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            for(char character : word.toCharArray()){
                sb.append(morseCode[character - 'a']);
            }
            morseSet.add(sb.toString());
            sb = new StringBuilder();
        }
        return morseSet.size();
    }
}
