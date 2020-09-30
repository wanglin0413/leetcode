package easy;

public class RotatedDigits {
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (isRotatedDigit2(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isRotatedDigit(int num) {
        String numString = num + "";
        //如果有invalid的num 就是false
        //如果没有invalid的num，只要有一个2 5 6 9 即可
        boolean has = false;
        for (char each : numString.toCharArray()) {
            if (each == '3' || each == '4' || each == '7') return false;
            if (each == '2' || each == '5' || each == '6' || each == '9') has = true;
        }
        return has;
    }

    private boolean isRotatedDigit2(int num) {
        boolean has = false;
        while (num != 0) {
            int each = num % 10;
            if (each == 3 || each == 4 || each == 7) return false;
            if (each == 2 || each == 5 || each == 6 || each == 9) has = true;
            num /= 10;
        }
        //如果有invalid的num 就是false
        //如果没有invalid的num，只要有一个2 5 6 9 即可

        return has;
    }
}
