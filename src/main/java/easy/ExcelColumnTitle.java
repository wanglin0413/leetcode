package easy;

public class ExcelColumnTitle {
    public String convertToTitle(int n) {
        //十进制转换为26进制
        //ascii 大写字母A--65
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            n--;
            int resual = n % 26;
            sb.append((char) (resual + 65));
            n /= 26;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        ExcelColumnTitle ect = new ExcelColumnTitle();
        System.out.println(ect.convertToTitle(26));
    }
}
