package easy;

import java.util.Arrays;

public class NumberOfLines {
    public int[] numberOfLines(int[] widths, String S) {
        int count = 0;
        int curLine = 0;
        for(char each : S.toCharArray()){
            if( curLine + widths[each - 'a'] > 100){
                count++;
                curLine = widths[each - 'a'];
            }else {
                curLine += widths[each - 'a'];
            }

        }
        return new int[]{count+1, curLine};
    }

    public static void main(String[] args) {
        int[] widths = new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String S = "abcdefghijklmnopqrstuvwxyz";
        NumberOfLines nl = new NumberOfLines();
        System.out.println(Arrays.toString(nl.numberOfLines(widths, S)));
    }
}
