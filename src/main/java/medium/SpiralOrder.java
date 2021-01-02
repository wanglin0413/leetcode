package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result  = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int count = m*n;
        int start = 0;
        int row = 0;
        int col = 0;
        int leftEnd = n;
        int downEnd = m;
        int rightEnd = 0;
        int upEnd = 1;
        int direction = 0;
        while(start < count){
            result.add(matrix[row][col]);
            start++;
            if(direction == 0){
                if(col == leftEnd - 1){
                    direction = 1;
                    leftEnd--;
                    row++;
                }else {
                    col++;
                }
            }else if(direction == 1){
                if(row == downEnd -1){
                    direction = 2;
                    downEnd--;
                    col--;
                }else {
                    row++;
                }
            }else if(direction == 2){
                if(col == rightEnd){
                    direction = 3;
                    rightEnd++;
                    row--;
                }else {
                    col--;
                }
            }else if(direction == 3){
                if(row == upEnd){
                    direction = 0;
                    upEnd++;
                    col++;
                }else {
                    row--;
                }
            }
        }
        //1. 向右 row不变 col++ 直到leftEnd；
        //2. 向下 col 不变，row++ 直到downEnd；
        //3. 向左 row不变 col-- 直到rightEnd;
        //4. 向上 col不变 row--，直到UpEnd；
        return result;
    }

    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        int[][] matrix = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        for(int[] row : matrix){
            System.out.println( Arrays.toString(row));
        }
        System.out.println(spiralOrder.spiralOrder(matrix));
    }
}
