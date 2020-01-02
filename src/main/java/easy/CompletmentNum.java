package easy;

public class CompletmentNum {
    public int findComplement(int num) {
        int i = 1;
        int tmp = num;
        while (num != 1){
            num >>>= 1;
            i <<= 1;
            i += 1;
        }
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(~tmp));
        return ~tmp & i;
    }

    public static void main(String[] args) {
        CompletmentNum cn = new CompletmentNum();
        System.out.println(cn.findComplement(7));
    }
}
