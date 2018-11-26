import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.List;

public class LetterCase {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        StringBuilder base = new StringBuilder();
        build(S, result, base);
        return result;
    }

    private void build(String s, List<String> result, StringBuilder base) {
        System.out.println(base.toString());
        int index = base.length();
        if(base.length() == s.length()){
            result.add(base.toString());
            return;
        }
        while (index < s.length() && Character.isDigit(s.charAt(index))){
            base.append(s.charAt(index));
            index++;
        }
        if(index < s.length()){
            StringBuilder temp = new StringBuilder(base);
            temp.append(Character.toLowerCase(s.charAt(index)));
            build(s, result, temp);
            base.append(Character.toUpperCase(s.charAt(index)));
            build(s,result, base);
        }else {
            result.add(base.toString());
        }
    }

    public static void main(String[] args) {
        LetterCase lc = new LetterCase();
        System.out.println(lc.letterCasePermutation("a1b2"));
    }
}
