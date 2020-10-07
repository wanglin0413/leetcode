package easy;

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        for(int rowC = 1; rowC < row; rowC++){
            for(int columnC = 1; columnC < column; columnC++){
                if(matrix[rowC][columnC] != matrix[rowC-1][columnC-1])return false;
            }
        }
        return true;
    }
}
