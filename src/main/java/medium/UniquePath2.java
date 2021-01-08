package medium;


public class UniquePath2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null)return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] table = new int[m][n];
		table[0][0] = obstacleGrid[0][0]==1?0:1;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(i == 0 && j == 0)continue;
				if(obstacleGrid[i][j] == 1){
					table[i][j] = 0;
				}else {
					int left = 0;
					if(i > 0){
						left = table[i-1][j];
					}
					int right = 0;
					if(j > 0){
						right = table[i][j-1];
					}
					table[i][j] = left+right;
				}
			}
		}
		return table[m-1][n-1];
	}

}
