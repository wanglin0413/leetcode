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
    public int titleToNumber(String s) {
        char[] titles = s.toCharArray();
        int n = titles.length;
        int result = 0;
        int base = 1;
        for(int i = n-1; i >=0; i--){
            result += (titles[i] - 'A' + 1) * base;
            base *= 26;
        }
        return result;
    }

    public static void main(String[] args) {
        ExcelColumnTitle ect = new ExcelColumnTitle();
        System.out.println(ect.convertToTitle(26));
        System.out.println(ect.titleToNumber("AB"));
    }
}
