package hard;

public class StringScramble {
    //有没有非递归的更快的方法？？
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length())return false;
        if(s1.length() == 0)return true;
        if(s1.equals(s2))return true;
        int[] freq = new int[26];
        for(int i = 0; i < s1.length(); i++){
            freq[s1.charAt(i) - 97]++;
            freq[s2.charAt(i) - 97]--;
        }
        for(int i = 0; i < s1.length(); i++)
            if(freq[s1.charAt(i) - 97] != 0) return false;
        for(int i = 1; i < s1.length(); i++){
            if(isScramble(s1.substring(0, i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i)))return true;
            if(isScramble(s1.substring(0,i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))return true;
        }
        return false;
    }


    public static void main(String[] args) {
        StringScramble ss = new StringScramble();
        System.out.println(ss.isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"));
    }
}
