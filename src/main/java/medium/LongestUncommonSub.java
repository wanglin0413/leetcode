package medium;

import java.util.*;

public class LongestUncommonSub {
    public int findLUSlength(String[] strs) {
        //审题很重要！！！这里的subquense的意义是，从b中删除任意字符（不能变换顺序），如果能转化成a，则a是b的subquense
        //不需要是连续的一段！！！
        int result = -1;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() <= result) continue;
            boolean isSub = false;
            for (int j = 0; j < strs.length; j++) {
                if(i == j)continue;
                if (isSubquense(strs[i], strs[j])) {
                    isSub =true;
                    break;
                }
            }
            if(!isSub){
                result = Math.max(result, strs[i].length());
            }
        }
        return result;
    }

    private boolean isSubquense(String str1, String str2) {
        if (str1.length() > str2.length()) return false;
        int i = 0;
        int j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == str1.length();
    }

    public static void main(String[] args) {
        LongestUncommonSub lus = new LongestUncommonSub();
        String[] test = new String[]{"a","b","c","d","e","f","a","b","c","d","e","f"};
        System.out.println(lus.findLUSlength(test));
    }
}
