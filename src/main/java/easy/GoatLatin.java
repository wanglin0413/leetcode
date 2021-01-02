package easy;

public class GoatLatin {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            if(word.charAt(0) == 'a' || word.charAt(0) == 'e' || word.charAt(0) == 'i' ||  word.charAt(0) == 'o' || word.charAt(0) == 'u'
                    ||word.charAt(0) == 'A' || word.charAt(0) == 'E' || word.charAt(0) == 'I' ||  word.charAt(0) == 'O' || word.charAt(0) == 'U'){
                sb.append(word);

            }else {
                sb.append(word.substring(1));
                sb.append(word.charAt(0));
            }
            sb.append("ma");
            for(int j = 0; j < i + 1; j++){
                sb.append("a");
            }
            sb.append(" ");
        }
        return sb.subSequence(0, sb.length() - 1).toString();
    }
}
