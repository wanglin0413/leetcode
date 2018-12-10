package easy;

public class Sqrt {
    public int mySqrt(int x) {
        if(x == 0)return 0;
        long begin =x;
        while (begin* begin > x || (begin+1)*(begin+1) <=x){
//            begin = begin - (begin* begin - x)/(2*begin);
            begin = (x/begin + begin)/2;
        }
        return (int) begin;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.mySqrt(16));
    }
}
