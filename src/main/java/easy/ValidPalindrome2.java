package easy;

public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        int length = s.length();
        if(length <= 2)return true;
        int i = 0;
        int j = length - 1;
        for(; i <length / 2; i++){
            if(s.charAt(i) != s.charAt(j - i)){
                    if(s.charAt(i+1) == s.charAt(j-i) && isPalindrome(s.substring(i+1, j-i+1))){
                        return true;
                    }
                    if(s.charAt(i) == s.charAt(j-i-1) && isPalindrome(s.substring(i, j-i))){
                        return true;
                    }
                    return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        for(int i = 0; i <s.length() / 2; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome2 vp2 = new ValidPalindrome2();
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(vp2.validPalindrome(s));
    }
}
