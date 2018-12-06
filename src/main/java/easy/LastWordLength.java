package easy;

public class LastWordLength {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int count=0;
        for(int i = chars.length-1; i >=0; i--){
            if(s.charAt(i) ==' '){
                if(count==0)continue;
                return count;
            }
            count++;
        }
        return count;
    }
}
