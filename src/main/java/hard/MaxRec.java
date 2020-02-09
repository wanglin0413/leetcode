package hard;


import java.util.Stack;

public class MaxRec {
    public int maximalRectangle(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int n = grid.length;
        if(n <= 0){
            return  0;
        }
        int area, maxArea = 0;

        int[] bar = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bar[j]++;
                } else if (grid[i][j] == '0'){
                    bar[j] = 0;
                }
            }
            area = maxHistogramArea(bar);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    //这里使用之前的，用栈的方法求最大面积，反而更慢
    public int maxHistogramArea(int[] bar) {
        int n = bar.length;
        int area, maxArea = 0;
        for (int i = 0; i < n; i++) {
            if (bar[i] == 0) {
                continue;
            }
            int minVal = bar[i];
            for (int j = i; j < n; j++) {
                if (bar[j] == 0) {
                    break;
                }
                if (bar[j] < minVal) {
                    minVal = bar[j];
                }
                if (bar[j] > minVal) {
                    area = minVal * (j - i + 1);
                } else {
                    area = Math.min(bar[j], bar[i]) * (j - i + 1);
                }
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {
        MaxRec mr = new MaxRec();
        char[][] chars = new char[][]{
                {'1','0','1','0','0'},
  {'1','0','1','1','1'},
  {'1','1','1','1','1'},
  {'1','0','0','1','0'}
};
        System.out.println(mr.maximalRectangle(chars));
    }
}
