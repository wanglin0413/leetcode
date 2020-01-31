package hard;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();

        boolean[][] dp = new boolean[slen+1][plen+1];
        dp[0][0] = true;

        for(int i=1; i<=plen; i++){
            dp[0][i] = p.charAt(i-1)=='*' && dp[0][i-1];
        }
        for(int i=1; i<=slen; i++){
            for(int j=1; j<=plen; j++){
                if((s.charAt(i-1) == p.charAt(j-1)) || p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
            }
        }
        return dp[slen][plen];
    }

    public static void main(String[] args) {
        WildcardMatching wildcardMatching = new WildcardMatching();
        wildcardMatching.isMatch("aab","c*a*b");
        String[] s = new String[]{"mississippi","ab","ba","adceb","aab","aa","aa","aa"};
        String[] p = new String[]{"m??*ss*?i*pi","?*","*a*","*a*b","c*a*b","a","a*","aa"};
        boolean[] result = new boolean[]{false, true, true,true,false,false,true,true};
        for(int i = 0; i <s.length; i++){
            if(wildcardMatching.isMatch(s[i], p[i]) != result[i]){
                System.out.println(s[i] + " : wrong");
            }
        }

    }
}
