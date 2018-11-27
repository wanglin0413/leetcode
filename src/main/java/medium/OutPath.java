package medium;

import utils.MyLog;

import java.util.Arrays;

public class OutPath {
    int[][][] cache;
    public int findPaths(int m, int n, int N, int i, int j) {
        //m 行数 n 列数 N最多的步数 i，j位置
        //f(i,j,N) = sum(f(i+-1,j+-1,N+1)
        cache = new int[m][n][N+1];
        for(int[][] each:cache){
            for(int[] eachrow:each){
                Arrays.fill(eachrow, -1);
            }
        }
        int result = countPath(m, n, N, i, j);
        return result;
    }

    private int countPath(int m, int n, int N, int i, int j) {
        if (N < 0) return 0;
        if (out(m, n, i, j)) {
            return 1;
        }
        if(cache[i][j][N] >=0)return cache[i][j][N];
        long result = 0;
        result += countPath(m, n, N - 1, i, j - 1) % 1000000007 ;
        result += countPath(m, n, N - 1, i, j + 1) % 1000000007 ;
        result += countPath(m, n, N - 1, i + 1, j) % 1000000007 ;
        result += countPath(m, n, N - 1, i - 1, j) % 1000000007 ;
        cache[i][j][N] = (int) (result % 1000000007);
        return cache[i][j][N];
    }

    private boolean out(int m, int n, int i, int j) {
        return i < 0 || j < 0 || i >= m || j >= n;
    }

    public static void main(String[] args) {
        OutPath op = new OutPath();
        System.out.println(op.findPaths(8, 50, 23, 5, 26));
    }
}
