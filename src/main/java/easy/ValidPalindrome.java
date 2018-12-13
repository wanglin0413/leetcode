package easy;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            while (left < n && !Character.isLetterOrDigit(chars[left])) left++;
            while (right >= 0 && !Character.isLetterOrDigit(chars[right])) right--;
            if (left >= right) return true;
            if (!equalsIgnoreCase(chars[left], chars[right]))return false;
            left++;
            right--;
        }
        return true;
    }

    private boolean equalsIgnoreCase(char char1, char char2) {
        if(char1 == char2)return true;
        if(char1 > 96 && char1 == char2 + 32)return true;
        if(char1 > 64 && char1 == char2 - 32)return true;
        return false;
    }

    public static void main(String[] args) {
        ValidPalindrome vpd = new ValidPalindrome();
        System.out.println(vpd.isPalindrome("0P"));
    }
}
