package easy;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0 || x % 10 ==0)return false;
        if(x < 10)return true;
        int num = x;
        long inverse = 0;
        while (num != 0){
            inverse = inverse*10 + num % 10;
            num /= 10;
        }
        return (int) inverse == x;
    }
}
