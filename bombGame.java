import java.util.ArrayList;

class bombGame {
	
	public static void main(String[] args)
	{	
		// box = '#'
		// obstacle = '*'
		// blank = '.'
		char[][] board = 
		{{'#','.','#'},
		 {'*','.','.'},
		 {'.','#','#'},
		 {'.','.','.'}};
		long startTime = System.nanoTime();
		char[][] output = play(board);
		long endTime = System.nanoTime();
		print(output, startTime, endTime);
	}

	public static char[][] play(char[][] board) {

		for(int i = 0; i < board.length - 1; i++) {
			ArrayList<int[]> detonationSites = new ArrayList<int[]>();
			for(int r = board.length - 2; r >= 0; r--) {
				for(int c = 0; c < board[0].length; c++) {
					if(board[r][c] == '#') {
						if(board[r + 1][c] == '.') {
							board[r + 1][c] = '#';
							board[r][c] = '.';
						} else if(board[r + 1][c] == '*') {
							int[] coordinates = {r + 1, c};
							detonationSites.add(coordinates);
							board[r + 1][c] = '#';
							board[r][c] = '.';
						}
					}
				}
			}
			for(int j = 0; j < detonationSites.size(); j++) {
				board = destroy(board, detonationSites.get(j)[0], detonationSites.get(j)[1]);
			}
		}
		return board;
	}

	public static char[][] destroy(char[][] board, int row, int column) {
		for(int r = row-1; r < row+2; r++) {
			for(int c = column-1; c < column+2; c++) {
				try {
					board[r][c] = '.';
				} catch(ArrayIndexOutOfBoundsException ex) {

				}
			}
		}
		return board;
	}

	public static void print(char[][] board, long startTime, long endTime) {
		for(int r = 0; r < board.length; r++) {
			System.out.println(board[r]);
		}
		System.out.println(endTime - startTime);
	}
}