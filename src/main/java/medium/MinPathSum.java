package medium;

import java.util.Arrays;

public class MinPathSum {

	public int minPathSum(int[][] grid) {
		if(grid == null)return 0;
		int row = grid.length;
		int col = grid[0].length;
		if(row == 1 && col == 1)return grid[0][0];
		int[] dp = new int[col];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = grid[0][0];
		for(int i =0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(i == 0 && j == 0)continue;
				if(j == 0){
					dp[j] = grid[i][j]+ dp[j];
				}else {
					dp[j] = grid[i][j] + Math.min(dp[j],dp[j-1]);
				}

			}
		}
		return dp[col-1];
	}

	public static void main(String[] args) {
		int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
		MinPathSum mps = new MinPathSum();
		System.out.println(mps.minPathSum(grid));
	}

}
