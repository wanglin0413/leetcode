package hard;

public class ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        if(s.length() == 0)return false;
        if(s.length() == 1 && (s.charAt(0) > '9' || s.charAt(0) < '0'))return false;
        if(s.charAt(0) == 'e' || s.charAt(s.length() -1) == 'e')return false;
        String[] numbers = s.split("e");
        if(numbers.length > 2)return false;
        if(numbers.length == 1)return pIsNumber(numbers[0]);
        return pIsNumber(numbers[0]) && aIsNumber(numbers[1]);
    }

    private boolean aIsNumber(String s) {
        char[] chars = s.toCharArray();
        int numberCount = 0;
        if((chars[0] < '0' || chars[0] > '9') && chars[0] != '+' && chars[0] != '-')return false;
        if(Character.isDigit(chars[0]))numberCount++;
        for(int i = 1; i < chars.length; i++){
            if(!Character.isDigit(chars[i]))return false;
            numberCount++;
        }
        if(numberCount == 0)return false;
        return true;
    }

    private boolean pIsNumber(String s) {
        char[] chars = s.toCharArray();
        if((chars[0] < '0' || chars[0] > '9') && chars[0] != '+' && chars[0] != '-' && chars[0] != '.')return false;
        int pointCount = 0, numberCount = 0;
        if(chars[0] == '.')pointCount++;
        if(Character.isDigit(chars[0]))numberCount++;
        for(int i = 1; i < chars.length - 1; i++){
            if((chars[i] < '0' || chars[i] > '9') && chars[i] != 'e' && chars[i] != '.')return false;
            if(chars[i] == '.')pointCount++;
            if(Character.isDigit(chars[i]))numberCount++;
        }
        if((chars[chars.length - 1] > '9' || chars[chars.length - 1] < '0') && chars[chars.length-1] != '.')return false;
        if(chars[chars.length - 1] == '.')pointCount++;
        if(Character.isDigit(chars[chars.length - 1]))numberCount++;
        if(pointCount > 1)return false;
        if(numberCount == 0)return false;
        return true;
    }

    public static void main(String[] args) {
        ValidNumber vn = new ValidNumber();
        System.out.println(vn.isNumber("4e3."));
    }
}
