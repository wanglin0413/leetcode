package medium;

public class Power {
    public double myPow(double x, int n) {
        if(n == 0)return 1;
        boolean reverse = (n < 0);
        long absN = n;
        double result = inMyPow(x, reverse?-absN:absN);
        return reverse?1/result:result;
    }

    private double inMyPow(double x, long n) {
        if(n == 1)return x;
        if(n %2 == 1){
            return x*inMyPow(x*x, n/2);
        }else {
            return inMyPow(x*x, n/2);
        }
    }

    public static void main(String[] args) {
        Power power = new Power();
        System.out.println(power.myPow(1.0000, -2147483648));
    }
}
