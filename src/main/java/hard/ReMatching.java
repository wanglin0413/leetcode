package hard;

public class ReMatching {
    //dp
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
        dp[0][0] = true;
        for(int i = 1; i <= s.length(); i++){
            dp[0][i] =false;
        }
        for(int i = 1; i <= p.length(); i++){
            if(p.charAt(i-1) == '*'){
                if(i < 2){
                    dp[i][0] = false;
                }else {
                    dp[i][0] = dp[i-2][0];
                }
            }else {
                dp[i][0] = false;
            }
        }
        for(int pIndex = 1; pIndex <= p.length(); pIndex++){
            for(int sIndex  = 1; sIndex <= s.length(); sIndex++){
                if(p.charAt(pIndex-1) == '*'){//如果p是*，则可以当 *和*前一个不存在，或者 *前的和s当前的前一个是否匹配
                    if(pIndex > 1 && dp[pIndex -2][sIndex]){//p上两个 当p中的 ？*不存在
                        dp[pIndex][sIndex] = true;
                    }else if(sIndex > 0 && dp[pIndex][sIndex-1]){//p不变，s前一个 如果匹配，且s当前这个和p前一个还相等
                        if(pIndex > 1 && (p.charAt(pIndex-2) == s.charAt(sIndex-1) || p.charAt(pIndex - 2) == '.')){
                            dp[pIndex][sIndex] = true;
                        }
                    }
                    else {
                        dp[pIndex][sIndex] = false;
                    }
                }else {//p不是*，就看斜对角前一个是否匹配，和当前是否匹配
                    dp[pIndex][sIndex] = (dp[pIndex-1][sIndex-1] && (p.charAt(pIndex-1) == '.' || p.charAt(pIndex-1) == s.charAt(sIndex-1)));
                }
            }
        }
        for(int i = 0; i <= p.length(); i++){
            for(int j = 0; j <= s.length(); j++){
                if(j == 0) System.out.print((i > 0 ? p.charAt(i-1): "    ") + "  ");
                System.out.print((dp[i][j] ? 1:0) +"   ");
            }
            System.out.println();
        }
        return dp[p.length()][s.length()];
    }
    public boolean isMatchRecursively(String s, String p) {
        if(p.isEmpty())return s.isEmpty();
        if(p.length() >= 2 && p.charAt(1) == '*'){
            return isMatchRecursively(s, p.substring(2)) || !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatchRecursively(s.substring(1), p);
        }else {
            return  !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatchRecursively(s.substring(1), p.substring(1));
        }
    }



    public static void main(String[] args) {
        ReMatching rm = new ReMatching();
        String s = "mississippi";
        String p = "mis*is*p*.";
        for(int j = 0; j <= p.length(); j++){
            for (int i = 0; i <= s.length(); i++){
                System.out.print((rm.isMatchRecursively(s.substring(0, i), p.substring(0, j))?1 : 0) + "   ");
            }
            System.out.println();
        }
        System.out.println(rm.isMatchRecursively(s,p));
        System.out.println(rm.isMatch(s,p));
    }
}
