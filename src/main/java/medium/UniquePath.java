package medium;

import java.util.Arrays;

public class UniquePath {
	public int uniquePaths(int m, int n) {
		if(m == 0 || n == 0)return 0;
		int[][] table = new int[m][n];
		Arrays.fill(table[0], 1);
		for(int i = 0; i < m; i++){
			table[i][0] = 1;
		}
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				table[i][j] = table[i-1][j] + table[i][j-1];
			}

		}
		return table[m-1][n-1];
	}

}
