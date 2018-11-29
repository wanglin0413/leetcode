package medium;

import java.util.Arrays;

public class DeleteOperation {
    public int minDistance(String word1, String word2) {
        //以i，j为结尾的字符串的最长子序列
        //画出表格来，找规律，不要光在脑子里想，一定要尝试把图画出来！
        //把解题思路用图标的形式表示出来，也是需要锻炼的，能画出图来，题目就解决了一大半，剩下的就是找规律了
        // 以i ,j 为结尾的字符串序列，需要删除的个数，如果word1[i]=word2[j]，就等于count[i-1][j-1]
        //如果不相等，就等于min(count[i-1][j], count[i][j-1])
        if(word1.length() == 0)return word2.length();
        if(word2.length() == 0)return word1.length();
        int[][] deleteCounts = new int[word1.length()+1][word2.length()+1];
        for(int i = 0; i < word2.length()+1; i++){
            deleteCounts[0][i] = i;
        }
        for(int i = 0; i < word1.length()+1; i++){
            deleteCounts[i][0] = i;
        }
        for(int[] eachRow : deleteCounts){
            System.out.println(Arrays.toString(eachRow));
        }
        System.out.println("------------------------");
        for(int i = 1; i < word1.length()+1; i++){
            for(int j = 1; j < word2.length()+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    deleteCounts[i][j] =deleteCounts[i-1][j-1];
                }else {
                    deleteCounts[i][j] = Math.min(deleteCounts[i-1][j]+1, deleteCounts[i][j-1] +1);
                }
            }
        }
        for(int[] eachRow : deleteCounts){
            System.out.println(Arrays.toString(eachRow));
        }
        return deleteCounts[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        DeleteOperation deOp = new DeleteOperation();
        System.out.println(deOp.minDistance("intention", "execution"));
    }
}
