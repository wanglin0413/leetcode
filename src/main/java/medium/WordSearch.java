package medium;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		int row = board.length;
		int col = board[0].length;
		boolean[][] path = new boolean[row][col];
		for(int i  = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(_exist(board, path, word,0, i, j))return true;
			}
		}
		return false;
	}

	private boolean _exist(char[][] board, boolean[][] path, String word, int index, int row, int col) {
		if(index == word.length())return true;
		if(row < 0 || col < 0 || row == board.length || col == board[0].length || path[row][col])return false;
		if(board[row][col] == word.charAt(index)){
			path[row][col] = true;
			boolean hasPath =  _exist(board, path, word, index+1, row + 1, col) ||
				_exist(board, path, word, index+1, row -1, col) ||
				_exist(board, path, word, index+1, row, col + 1) ||
				_exist(board, path, word, index+1, row, col - 1);
			if(hasPath){
				return true;
			}else {
				path[row][col] = false;
				return false;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		WordSearch wordSearch = new WordSearch();
		char[][] board = new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};

		System.out.println(wordSearch.exist(board, "ABCESEEEFS"));
	}

}
