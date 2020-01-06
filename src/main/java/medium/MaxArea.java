package medium;

public class MaxArea {

    //Draw a matrix where rows correspond to the position of the left line,
    // and columns corresponds to the position of the right line.
    // We start by computing the volume at (1,6), denoted by o.
    // Now if the left line is shorter than the right line,
    // then moving the right line towards left would only decrease the volume,
    // so all the elements left to (1,6) on the first row have smaller volume.
    // Therefore, we don't need to compute those cases (crossed by ---).
    //
    //            1 2 3 4 5 6
    //            1 x ------- o
    //            2 x x
    //            3 x x x
    //            4 x x x x
    //           5 x x x x x
    //          6 x x x x x x
    //    So we can only move the left line towards right to 2 and compute (2,6).
    // Now if the right line is shorter, all cases below (2,6) are eliminated.
    //
    //            1 2 3 4 5 6
    //            1 x ------o
    //            2 x x      o
    //           3 x x x     |
    //           4 x x x x   |
    //           5 x x x x x |
    //           6 x x x x x x
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        while (j > i) {
            int tmp = Math.min(height[i], height[j]) * (j - i);
            if (tmp > max) max = tmp;
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        MaxArea ma = new MaxArea();
        System.out.println(ma.maxArea(height));
    }
}
