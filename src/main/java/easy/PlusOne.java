package easy;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        int[] newDigits = new int[n+1];
        newDigits[0]=1;
        int i = 1;
        while (i < n+1){
            newDigits[i++] = digits[i-2];
        }
        return newDigits;
    }

    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        System.out.println(Arrays.toString(po.plusOne(new int[]{9,9,9,9})));
    }
}
