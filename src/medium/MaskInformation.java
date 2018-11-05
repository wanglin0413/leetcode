package medium;

public class MaskInformation {
    public String maskPII(String S) {
        int index = S.indexOf('@');
        StringBuilder sb = new StringBuilder();
        if(index != -1){
            sb.append(Character.toLowerCase(S.charAt(0)));
            sb.append("*****");
            sb.append(Character.toLowerCase(S.charAt(index - 1)));
            sb.append(S.substring(index).toLowerCase());
        }else {
            StringBuilder digits = new StringBuilder();
            for(char each:S.toCharArray()){
                if(Character.isDigit(each)){
                    digits.append(each);
                }
            }
            if(digits.length() > 10){
                sb.append("+");
                for(int i = 0; i < digits.length() - 10; i++){
                    sb.append("*");
                }
                sb.append("-");
            }
            sb.append("***-***-");
            sb.append(digits.subSequence(digits.length() - 4,digits.length()));

        }
        return sb.toString();
    }
}
