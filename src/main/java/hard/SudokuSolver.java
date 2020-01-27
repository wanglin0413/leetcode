package hard;

import java.util.*;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        //每个3*3 不重复
        int[][] boardMap = new int[9][9];
        //每行 不重复
        int[][] rowMap = new int[9][9];
        //每列 不重复
        int[][] columnMap = new int[9][9];

        for(int rowIndex = 0; rowIndex < 9; rowIndex++){
           for(int columnIndex = 0; columnIndex < 9; columnIndex++){
               char cur = board[rowIndex][columnIndex];
               int boardIndex = rowIndex/3 * 3 + columnIndex/3;
               if(cur != '.'){
                   int numIndex = cur - '0' - 1;
                   rowMap[rowIndex][numIndex] = 1;
                   columnMap[columnIndex][numIndex] = 1;
                   boardMap[boardIndex][numIndex] = 1;
               }
           }
        }
        solveSudokuRecursively(board, rowMap, columnMap, boardMap,0,0);
    }

    private boolean solveSudokuRecursively(char[][] board, int[][] rowMap, int[][] columnMap, int[][] boardMap, int row, int column) {
        //如果都摆完了，就返回
        if(row == 9)return true;
        if(board[row][column] != '.'){
            if(column == 8){
                return solveSudokuRecursively(board, rowMap, columnMap, boardMap, row+1, 0);
            }else {
                return solveSudokuRecursively(board, rowMap, columnMap, boardMap, row, column+1);
            }
        }
        //当前row 和 column 从符合条件的数字中选一个
        int boardIndex = row/3 * 3 + column /3;
        boolean hasWay = false;
        for(int numIndex = 0; numIndex < 9; numIndex++){
            if(rowMap[row][numIndex] == 1)continue;
            char each = (char) (numIndex +1 +'0');
            if(columnMap[column][numIndex] == 0 && boardMap[boardIndex][numIndex] == 0){
                board[row][column] = each;
                columnMap[column][numIndex] = 1;
                rowMap[row][numIndex] = 1;
                boardMap[boardIndex][numIndex] = 1;
                if(column == 8){
                    hasWay = solveSudokuRecursively(board, rowMap, columnMap, boardMap, row+1, 0);
                }else {
                    hasWay = solveSudokuRecursively(board, rowMap, columnMap, boardMap, row, column+1);
                }
                if(!hasWay){
                    columnMap[column][numIndex] = 0;
                    rowMap[row][numIndex] = 0;
                    boardMap[boardIndex][numIndex] = 0;
                    board[row][column] = '.';
                }
            }
        }
        return hasWay;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        SudokuSolver ss = new SudokuSolver();
        ss.solveSudoku(board);
        for(char[] each : board){
            System.out.println(Arrays.toString(each));
        }
    }
}
