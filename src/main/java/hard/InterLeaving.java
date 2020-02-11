package hard;

import java.util.Arrays;

public class InterLeaving {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length())return false;
        int[][] path = new int[s2.length()+1][s1.length()+1];
        path[0][0] = 0;
        for(int i = 1; i < s1.length()+1; i++){
            if(s1.charAt(i-1) == s3.charAt(i-1) && path[0][i-1] != -1){
                path[0][i] = i;
            }else {
                path[0][i] = -1;
            }
        }
        for(int i = 1; i < s2.length()+1; i++){
            if(s2.charAt(i-1) == s3.charAt(i-1) && path[i-1][0] != -1){
                path[i][0] = i;
            }else {
                path[i][0] = -1;
            }
        }
        for(int j = 1; j < s2.length()+1; j++){
            for(int i = 1; i < s1.length()+1; i++){
                int above = path[j-1][i];
                int right = path[j][i-1];
                if( above != -1 && s3.charAt(above) == s2.charAt(j-1)){
                    path[j][i] = path[j-1][i]+1;
                }else if( right != -1 && s3.charAt(right) == s1.charAt(i-1)){
                    path[j][i] = path[j][i-1]+1;
                }else {
                    path[j][i] = -1;
                }
            }
        }
        for(int[] each : path){
            System.out.println(Arrays.toString(each));
        }
        return path[s2.length()][s1.length()] == s3.length();
    }

    public static void main(String[] args) {
        InterLeaving il = new InterLeaving();
        System.out.println(il.isInterleave("a", "b", "a"));
    }
}
