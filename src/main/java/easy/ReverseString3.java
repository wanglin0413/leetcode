package easy;

public class ReverseString3 {
    public String reverseWords(String s) {
        int length = 0;
        char[] sChar = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(sChar[i] == ' '){
                reverse(sChar, i - length, length);
                length = 0;
            }else {
                length++;
            }
        }
        reverse(sChar, s.length()-length, length);
        return new String(sChar);
    }

    private void reverse(char[] sChar, int start, int length) {
        for(int i = 0; i < length/2; i++){
            char tmp = sChar[start+i];
            sChar[start+i] = sChar[start+length-1-i];
            sChar[start+length-1-i] = tmp;
        }
    }

    public static void main(String[] args) {
        ReverseString3 rs3= new ReverseString3();
        String s = "Let's take LeetCode contest";
        System.out.println(rs3.reverseWords(s));
    }
}
