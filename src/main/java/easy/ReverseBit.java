package easy;

public class ReverseBit {
    public int reverseBits(int n) {
        System.out.println(Integer.toBinaryString(n));
        int result = 0;
        int count = 0;
        while (count < 32){
            result <<= 1;
            result ^= (n & 1);
            n >>= 1;
//            System.out.println(Integer.toBinaryString(n));
//            System.out.println(Integer.toBinaryString(result));
//            System.out.println("--------------------------------------");
            count++;
        }
        System.out.println(Integer.toBinaryString(result));
        return result;
    }

    public static void main(String[] args) {
        ReverseBit ri = new ReverseBit();
        int testcast = 0b11111111111111111111111111111101;
//        System.out.println(testcast);
        ri.reverseBits(testcast);
    }
}
