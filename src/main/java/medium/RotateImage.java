package medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RotateImage {
    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length/2; i++){
            for(int j = i; j < matrix.length - i- 1; j++){
                spin4(matrix, i, j);
            }
        }
    }

    private void spin4(int[][] matrix, int i, int j) {
        int tmp = matrix[i][j];
        int next;
        for(int k = 0; k < 4; k++){
            int nexti = j;
            int nextj = matrix.length  - i -1;
            next = matrix[nexti][nextj];
            matrix[nexti][nextj] = tmp;
            tmp = next;
            i = nexti;
            j = nextj;
        }
    }

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotateImage.rotate(matrix);
        for(int[] row: matrix){
            System.out.println(Arrays.toString(row));
        }
    }
}
