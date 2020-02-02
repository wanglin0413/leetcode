package hard;

public class NQueens2 {
    public int totalNQueens(int n) {
        boolean[] colUsed = new boolean[n];
        boolean[] diag1 = new boolean[2*n-1];
        boolean[] diag2 = new boolean[2*n-1];
        return count(colUsed, diag1, diag2, n, 0);
    }

    private int count(boolean[] colUsed, boolean[] diag1, boolean[] diag2, int n, int row) {
        if(row == n)return 1;
        int result = 0;
        for(int column = 0; column < n; column++){
            if(!colUsed[column] && !diag1[row+column] && !diag2[row+n-1-column]){
                colUsed[column] = true;
                diag1[row+column] = true;
                diag2[row+n-column-1] = true;
                result += count(colUsed, diag1, diag2, n, row+1);
                colUsed[column] = false;
                diag1[row+column] = false;
                diag2[row+n-column-1] = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NQueens2 nq2 = new NQueens2();
        System.out.println(nq2.totalNQueens(9));
    }
}
