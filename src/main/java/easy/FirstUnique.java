package easy;

import java.util.Arrays;

public class FirstUnique {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        Arrays.fill(count, 0);
        for(char each: s.toCharArray()){
            int indexi = each-97;
            count[indexi]++;
            }
        for(int i = 0; i < s.length(); i++){
            int indexi = s.charAt(i)-97;
            if(count[indexi] == 1)return i;
        }
      return -1;
    }
}
