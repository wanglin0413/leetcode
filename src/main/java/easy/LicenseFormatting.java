package easy;

public class LicenseFormatting {
    public String licenseKeyFormatting(String S, int K) {
        char[] chars = S.toCharArray();
        int n = chars.length;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = n-1; i >=0; i--){
            if(chars[i] != '-'){
                count++;
                if(chars[i] >= 'a' && chars[i] <= 'z'){
                    sb.append((char)(chars[i] - 32));
                }else{
                    sb.append(chars[i]);
                }
            }
            if(count == 4){
                sb.append('-');
                count = 0;
            }
        }
        if(sb.length() == 0)return "";
        if(sb.charAt(sb.length() -1) == '-'){
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        LicenseFormatting lf = new LicenseFormatting();
        System.out.println(lf.licenseKeyFormatting("5F3Z-2e-9-w",
                4));
    }
}
