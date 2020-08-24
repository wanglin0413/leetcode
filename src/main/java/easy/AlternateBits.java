package easy;

public class AlternateBits {
    public boolean hasAlternatingBits(int n) {

//        int i = n % 2;
//        n = n/2;
//        while(n != 0){
//            int cur = n % 2;
//            if(cur == i)return false;
//            i = cur;
//            n = n/2;
//        }
//        return true;

        return (n & (n >> 1)) == 0 && (n | (n >> 2)) == n;
    }

    public static void main(String[] args) {
        AlternateBits ab = new AlternateBits();
        System.out.println(ab.hasAlternatingBits(5));
    }
}
