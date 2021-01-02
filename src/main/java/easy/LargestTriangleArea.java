package easy;

public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double result = 0.0;
        for(int i=0; i<points.length; i++){
            for(int j=i+1; j<points.length; j++){
                for(int k=j+1; k<points.length; k++){
                    double area = calArea(points[i], points[j], points[k]);
                    if( area > result )
                        result = area;
                }
            }
        }
        return result;
    }

    private double calArea(int[]A, int[]B, int[]C){
        double areaA = A[0] * (B[1] - C[1]);
        double areaB = B[0] * (C[1] - A[1]);
        double areaC = C[0] * (A[1] - B[1]);
        return Math.abs((areaA+areaB+areaC)/2);
    }

}
