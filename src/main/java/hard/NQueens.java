package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        //进一步优化，使用col_used diag1_used diag2_used来记录是否可放，减少check的时间复杂度，但增加了空间复杂度
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] each : board){
            Arrays.fill(each, '.');
        }
        //每一行的每一个位置，尝试放queen
        solveNQueens(result, n, board, 0);
        return result;
    }

    private void solveNQueens(List<List<String>> result, int n, char[][] board, int row) {
        if(row == n){
            result.add(generateResult(board));
            return;
        }
        //对于该行的每个位置，都放一个试试
        for (int column = 0; column < n; column++) {
            if (check(board, row, column)) {
                board[row][column] = 'Q';
                solveNQueens(result, n, board, row+1);
                board[row][column] = '.';
            }
        }
    }
    //检查row column放queen是否违反规则
    private boolean check(char[][] board, int row, int column) {
        int n = board.length;
        //检查前面行，当前列是否有
        //检查前面行的，斜着的是否有
        for(int i = 0; i < row; i++){
            if(board[i][column] == 'Q')return false;
            int diff = row - i;
            if((column - diff >= 0 && board[i][column- diff] == 'Q') || (column+diff < n && board[i][column+diff] == 'Q'))return false;
        }
        return true;
    }

    //根据board情况，生成棋盘结果
    private List<String> generateResult(char[][] board) {
        List<String> result = new ArrayList<>();
        for(char[] row : board){
            result.add(String.valueOf(row));
        }
        return result;
    }

    public static void main(String[] args) {
        NQueens nq = new NQueens();
        List<List<String>> result = nq.solveNQueens(9);
        for(List<String> each : result){
            System.out.println(each.toString());
        }
    }
}
