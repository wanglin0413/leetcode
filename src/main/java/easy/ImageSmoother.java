package easy;

import java.util.Arrays;

public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int[][] result = new int[M.length][M[0].length];
        int rowL = M.length;
        int colL = M[0].length;
        if(rowL == 1 && colL == 1)return M;

        for(int row = 0; row < rowL; row++){
            for(int col = 0; col < colL; col++){
                int count = 1;
                int sum = M[row][col];
                if(row >= 1 && col >= 1){
                    sum += M[row -1][col -1];
                    count++;
                }
                if(row >= 1){
                    sum += M[row -1][col];
                    count++;
                }
                if(row >= 1 && col < colL - 1){
                    sum += M[row -1][col+1];
                    count++;
                }
                if(col >= 1){
                    sum += M[row][col -1];
                    count++;
                }
                if(col < colL - 1){
                    sum += M[row][col +1];
                    count++;
                }
                if(row < rowL - 1 && col >= 1){
                    sum += M[row +1][col -1];
                    count++;
                }
                if(row < rowL - 1){
                    sum += M[row +1][col];
                    count++;
                }
                if(row < rowL - 1 && col < colL - 1){
                    sum += M[row +1][col +1];
                    count++;
                }
                result[row][col] = sum / count;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ImageSmoother is = new ImageSmoother();

        int[][] M = new int[][]{{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        int[][] result = is.imageSmoother(M);
        for(int[] each : result){
            System.out.println(Arrays.toString(each));
        }
    }
}
