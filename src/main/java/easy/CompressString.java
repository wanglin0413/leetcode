package easy;

import java.util.Arrays;

public class CompressString {
        public int compress(char[] chars) {
            if(chars == null)return 0;
            if(chars.length == 1)return 1;
            int length = 0;
            int cur = 0;
            for(int i =0; i < chars.length; i++){
                if( i == chars.length - 1 || chars[i+1] != chars[cur]){
                    chars[length++] = chars[cur];
                    if(i-cur > 0){
                        char[] countchar = (""+(i-cur+1)).toCharArray();
                        for(int j = 0; j < countchar.length; j++){
                            chars[length+j] = countchar[j];
                        }
                        length+=countchar.length;
                    }
                    cur = i+ 1;
                }
            }
            return length;
        }

    public static void main(String[] args) {
        CompressString cs = new CompressString();
        char[] test = new char[]{'a','a','b','b','c','c','c'};
        System.out.println(cs.compress(test));
        System.out.println(Arrays.toString(test));
    }
}
