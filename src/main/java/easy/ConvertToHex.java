package easy;

public class ConvertToHex {
    public String toHex(int num) {
        if(num == 0)return "0";
        char[] ele = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder sb = new StringBuilder();
        long n = num;
        if(n < 0){
            n = n >>> 32;
        }
        while(n != 0){
            int yu = (int)(n%16);
            sb.append(ele[yu]);
            n /=16;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ConvertToHex ch = new ConvertToHex();
        System.out.println(ch.toHex(-1));
    }
}
