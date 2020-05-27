package easy;

public class FibonacciNumber {
    public int fib(int N) {
        if(N == 0)return 0;
        if(N == 1)return 1;
        int n0 = 0;
        int n1 = 1;
        int n2 = n1 + n0;
        for (int i = 2; i <=N; i++){
            n2 = n0+n1;
            n0 = n1;
            n1 = n2;
        }
        return n2;
    }

    public static void main(String[] args) {
        FibonacciNumber fn = new FibonacciNumber();
        System.out.println(fn.fib(9));
    }
}
