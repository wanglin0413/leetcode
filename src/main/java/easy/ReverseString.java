package easy;

public class ReverseString {
    public String reverseStr(String s, int k) {
        char[] schar = s.toCharArray();
        int remain = s.length() % (2*k);
        int begin = s.length()/(2*k)*(2*k);
        for(int i = 0; i < begin; i+=2*k){
            for(int j = 0; j < k/2; j++){
                swap(schar, i+j, i+k-1-j);
            }
        }

        if(remain < k){
            for(int j = 0; j < remain/2; j++){
                swap(schar, begin+j, begin + remain-1 - j);
            }
        }else {
            for(int j = 0; j < k/2; j++){
                swap(schar, begin+j, begin+k-1-j);
            }
        }
        return new String(schar);
    }

    private void swap(char[] s, int first, int second) {
        char tmp = s[first];
        s[first] = s[second];
        s[second] = tmp;
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        String s = "abcdef";
        System.out.println(rs.reverseStr(s, 6));
    }
}

