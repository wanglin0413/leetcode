package medium;

public class SearchMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null) {
			return false;
		}
		int row = matrix.length;
		int low = 0;
		int high = row;
		int mid = 0;
		while (low != high){
				mid = (low + high) >> 1;
				if(matrix[mid][0] == target)return true;
				if(matrix[mid][0] > target){
					high = mid;
				}else {
					low = mid + 1;
				}
		}
		if(low >= row && matrix[row-1][0] <= target){
			return binarySearch(matrix[low - 1], target);
		}
		if(matrix[low][0] > target){
			if(low == 0)return false;
			return binarySearch(matrix[low - 1], target);
		}
		if(matrix[low][0] <= target){
			return binarySearch(matrix[low], target);
		}
		return false;
	}

	private boolean binarySearch(int[] matrix, int target) {
		int low = 0;
		int high = matrix.length;
		while (low < high){
			int mid = (low + high) >> 1;
			if(matrix[mid] == target)return true;
			if(matrix[mid] < target){
				low = mid+1;
			}else {
				high = mid;
			}
		}
		return false;
	}

	public static void main(String[] args) {
//		int[][] matrix = new int[][]
//			{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int[][] matrix = new int[][]{{1,3}};
		SearchMatrix sm = new SearchMatrix();
		System.out.println(sm.searchMatrix(matrix, 3));
	}

}
