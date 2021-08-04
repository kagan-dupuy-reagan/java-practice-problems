
class fallingShape {
    public static void main(String[] args) {
        int[][] shape =
        {{0,1,1,0},
		 {0,1,0,0},
		 {0,0,0,0},
		 {0,0,0,0}};

        int[][] board =
        {{0,0,0,0},
		 {0,0,0,0},
		 {0,1,0,0},
		 {0,1,0,0}};
        
        long startTime = System.nanoTime();
        board = play(board, shape);
        long endTime = System.nanoTime();

        print(board, startTime, endTime);
    }

    public static int[][] play(int[][] board, int[][] shape) {
        for(int r = 0; r < shape.length)
    }

    public static void print(int[][] board, long startTime, long endTime) {
		for(int r = 0; r < board.length; r++) {
			System.out.println(board[r]);
		}
		System.out.println(endTime - startTime);
	}
}
