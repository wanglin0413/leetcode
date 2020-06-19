package easy;

public class ReshapeMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums == null)return nums;
        int origin_r = nums.length;
        int origin_c = nums[0].length;
        int n = origin_c * origin_r;
        if(r < 0 || c < 0)return nums;
        if(n != r*c)return nums;
        int[][] result = new int[r][c];
        for(int i = 0; i < n; i++){
            result[i/c][i % c] = nums[i/origin_c][i%origin_c];
        }
        return result;
    }

    public static void main(String[] args) {
        ReshapeMatrix rm = new ReshapeMatrix();
        int[][] nums = new int[][]{{1,2},{3,4}};
        System.out.println(rm.matrixReshape(nums, 1, 4));
    }
}
