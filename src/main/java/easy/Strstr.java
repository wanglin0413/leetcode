package easy;

public class Strstr {
    public int strStr(String haystack, String needle) {
        int n1 = haystack.length();
        int n2 = needle.length();
        if(n2 > n1) return -1;
        int result = 0;
        int index1 = 0;
        int index2 = 0;
        for(result = 0 ; result <= n1 - n2; result++){
            index1 = result;
            index2 = 0;
            while (haystack.charAt(index1++) == needle.charAt(index2++)){
                if(index2 == n2)return result;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Strstr strstr = new Strstr();
        System.out.println(strstr.strStr("a", "a"));
    }
}
