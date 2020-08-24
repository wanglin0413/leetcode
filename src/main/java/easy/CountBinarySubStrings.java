package easy;

public class CountBinarySubStrings {
    public int countBinarySubstrings(String s) {
        if(s.length() == 1)return 0;
        char[] chars = s.toCharArray();
        int count = 0;
        int prevCount = 0;
        int curCount = 1;
        int cur = chars[0];
        for(int i = 1; i < chars.length; i++){
           if(chars[i] == cur){
               curCount++;
           }else {
               count += Math.min(prevCount, curCount);
               prevCount = curCount;
               curCount = 1;
               cur = chars[i];
           }
        }
        count += Math.min(prevCount, curCount);
        return count;
    }

    public static void main(String[] args) {
        CountBinarySubStrings cbs = new CountBinarySubStrings();
        System.out.println(cbs.countBinarySubstrings("000111000"));
    }
}
