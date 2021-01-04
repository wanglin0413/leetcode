package medium;

import java.util.Arrays;

public class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int rowIdx = 0;
        int colIdx = 0;
        boolean right = true;
        int bigEnd = n-1;
        boolean down = false;
        int smallEnd = 0;
        boolean left= false;
        boolean up = false;
        for(int i = 1; i <= n*n; i++){
            result[rowIdx][colIdx] = i;
            if(right){
                colIdx++;
                if(colIdx == bigEnd){
                    right = false;
                    down = true;
                    continue;
                }
            }
            if(down){
                rowIdx++;
                if(rowIdx == bigEnd){
                    down = false;
                    left = true;
                    bigEnd -= 1;
                    continue;
                }
            }
            if(left){
                colIdx--;
                if(colIdx == smallEnd){
                    left = false;
                    up = true;
                    smallEnd++;
                    continue;
                }
            }
            if(up){
                rowIdx--;
                if(rowIdx == smallEnd){
                    right = true;
                    up = false;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] result = spiralMatrix.generateMatrix(1);
        for(int[] row : result){
            System.out.println(Arrays.toString(row));
        }
    }
}
