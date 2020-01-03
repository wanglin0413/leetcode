package medium;

public class ATOI {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0)return 0;
        long result = 0;
        char[] chars = str.toCharArray();
        int sign = 1;
        int index = 0;
        if(chars[0] == '-'){
            sign = -1;
            index = 1;
        }else if(chars[0] =='+'){
            sign = 1;
            index = 1;
        }
        for(; index < str.length(); index ++){
            if(Character.isDigit(chars[index])){
                result = result*10 + chars[index] - '0';
            }else {
                break;
            }
            if(result > Integer.MAX_VALUE){
                if(sign == 1)return Integer.MAX_VALUE;
                return Integer.MIN_VALUE;
            }
        }

        return (int) result*sign;
    }

    public int myAtoi2(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        boolean begins = false;
        boolean positive = true;
        for(char each : chars){
            if(!Character.isDigit(each) && each != ' ' && each != '-' && each != '+'){
                break;
            }
            if(begins && !Character.isDigit(each)){
                break;
            }
            if(each == '-'){
                sb.append(each);
                positive = false;
            }
            if(Character.isDigit(each)){
                sb.append(each);
            }
            if(each != ' ')begins = true;
        }
        if(sb.length() == 0)return 0;
        if(sb.length() == 1 && sb.charAt(0) == '-')return 0;
        try{
            return Integer.parseInt(sb.toString());
        }catch (Exception e){
            if(positive)return Integer.MAX_VALUE;
            return Integer.MIN_VALUE;
        }

    }

    public static void main(String[] args) {
        ATOI atoi = new ATOI();
        System.out.println(atoi.myAtoi("9223372036854775808"));
    }
}
