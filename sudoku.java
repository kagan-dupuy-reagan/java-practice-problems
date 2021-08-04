import java.util.HashSet;

public class sudoku {
    public static void main(String[] args) {
        String[][] board = 
		{{"1","","","","","","","",""},
         {"","","","","","","","","2"},
		 {"","","","","","","","",""},
		 {"","","","","","","","",""},
         {"","","","","","","","",""},
         {"","","","","","","","",""},
         {"","","","","","","1","",""},
         {"","","","","","","","",""},
         {"","","","","","","","","1"}};
         long startTime = System.nanoTime();
         check(board);
         long endTime = System.nanoTime();
         System.out.println(endTime - startTime);

    }

    public static boolean check(String[][] board) {

        for(int r = 0; r < 9; r++) {
            HashSet<String> rowSet = new HashSet<>();
            for(int c = 0; c < 9; c++) {
                if(!board[r][c].equals("") && rowSet.contains(board[r][c])) {
                    System.out.println("violated row at row: " + (r + 1) + " column: " + (c + 1));
                    return false;
                } else {
                    rowSet.add(board[r][c]);
                }
            }
        }

        for(int c = 0; c < 9; c++) {
            HashSet<String> colSet = new HashSet<>();
            for(int r = 0; r < 9; r++) {
                if(!board[r][c].equals("") && colSet.contains(board[r][c])) {
                    System.out.println("violated col at row: " + (r + 1) + " column: " + (c + 1));
                    return false;
                } else {
                    colSet.add(board[r][c]);
                }
            }
        }

        for(int i = 0; i < 9; i+=3) {
            for(int j = 0; j < 9; j+=3) {
                HashSet<String> squareSet = new HashSet<>();
                for(int r = i; r < i + 3; r++) {
                    for(int c = j; c < j + 3; c++) {
                        if(!board[r][c].equals("") && squareSet.contains(board[r][c])) {
                            System.out.println("violated square at row: " + (r + 1) + " column: " + (c + 1));
                            return false;
                        } else {
                            squareSet.add(board[r][c]);
                        }
                    }
                }
            }
        }
        System.out.println("All good in the hood");
        return true;
    }
}
