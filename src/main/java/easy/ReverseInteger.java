package easy;

public class ReverseInteger {
    public int reverse(int x) {
        String chars = String.valueOf(x);
        int index = 0;
        if(x < 0){
            index = 1;
        }
        long base = 1;
        long result = 0;
        for(int i = index; i < chars.length(); i++){
           result += (chars.charAt(i) - 48) * base;
           base *=10;
        }
        if(result > Integer.MAX_VALUE)return 0;
        if(x < 0) return (int)-result;
        return (int)result;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(1534236469));
    }
}
