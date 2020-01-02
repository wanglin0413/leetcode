package easy;

public class AddString {
    public String addStrings(String num1, String num2) {
        char[] intNum1 = num1.toCharArray();
        int length1 = intNum1.length;
        char[] intNum2 = num2.toCharArray();
        int length2 = intNum2.length;
        char[] result = new char[Math.max(length1, length2) + 1];
        boolean carry = false;
        for(int i =0; i < result.length; i++){
            int int1 = 0;
            if(i < length1){
                int1 = intNum1[length1 - 1 - i] - 48;
            }
            int int2 = 0;
            if(i < length2){
                int2 = intNum2[length2 - 1 - i] - 48;
            }
            int cur = carry? int1+int2+1 : int1+int2;
            if(cur >= 10){
                cur-=10;
                carry = true;
            }else{
                carry = false;
            }
            result[result.length - 1 -i] = (char) (cur+48);
        }

        return result[0] == '0'? new String(result,1, result.length-1):new String(result);
    }

    public static void main(String[] args) {
        AddString as = new AddString();
        as.addStrings("9", "99");
    }
}
