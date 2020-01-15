package medium;

public class DivideTwoInt {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if(divisor == 1)return dividend;
        if(dividend == Integer.MIN_VALUE && divisor == -1)return Integer.MAX_VALUE;
        boolean negative = (Integer.signum(dividend) != Integer.signum(divisor));
        int result = 0;
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int x = 1;
        int count = 0;
        while (a - b >= 0) {
            while (a - (b << x) >= 0){
                x++;
                count++;
            }
            while (a -(b<<x) < 0){
                x--;
                count++;
            }
            result+=1<<x;
            a -= b<<x;
        }
        System.out.println(count);
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        DivideTwoInt dti = new DivideTwoInt();
        System.out.println(dti.divide(-2147483648, -3));
    }
}
