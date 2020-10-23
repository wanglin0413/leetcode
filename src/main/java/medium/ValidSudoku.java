package medium;

import java.util.Arrays;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[] row = new boolean[9];
        boolean[] column = new boolean[9];
        boolean[] square = new boolean[9];
        for(int i = 0; i < 9; i++){
            Arrays.fill(row, false);
            Arrays.fill(column, false);
            Arrays.fill(square, false);
            for(int j = 0; j < 9; j++){
                int idx = board[i][j]-'1';
                if(idx >= 0){
                    if(row[idx])return false;
                    row[idx] = true;
                }


                idx = board[j][i]-'1';
                if(idx >= 0){
                    if(column[idx])return false;
                    column[idx] = true;
                }

                //9*9的小格 划分成 3*3的三个大格
                // i为大格的索引
                // i/3为大格的行索引，i/3 * 3为大格的基点行索引
                //i%3为大格的列索引，i%3*3为大格的基点列索引
                //j为一个大格中的小格索引
                //j/3 为小格的行索引，j%3为小格的列索引
                idx = board[i/3*3 + j/3][i%3*3 + j%3]-'1';
                if(idx < 0)continue;
                if(square[idx])return false;
                square[idx] = true;
            }
        }


        return true;
    }

    public static void main(String[] args) {
        ValidSudoku vs = new ValidSudoku();
        char[][] sudoku = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(vs.isValidSudoku(sudoku));
    }
}
