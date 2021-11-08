class Solution {
    private static final int GRID_SIZE = 9;
    public void solveSudoku(char[][] board) {
        if(solveBoard(board)) System.out.println("Solved successfully!!!");
        else System.out.println("Unsolveable");
        for(int row = 0; row < GRID_SIZE; row++) {
            if(row%3 == 0 && row != 0) System.out.println("------------");
            for(int col = 0; col < GRID_SIZE; col++) {
                if(col%3 == 0 && col != 0) System.out.print("|");
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }
    private static boolean isNumberInRow(char[][] board, char num, int row) {
        for(int i = 0; i < GRID_SIZE; i++) {
            if(board[row][i] == num) return true;
        }
        return false;
    }
    private static boolean isNumberInColumn(char[][] board, char num, int col) {
        for(int i = 0; i < GRID_SIZE; i++) {
            if(board[i][col] == num) return true;
        }
        return false;
    }
    private static boolean isNumberInBox(char[][] board, char num, int row, int col) {
        int localRow = row - row%3;
        int localCol = col - col%3;
        for(int i = localRow; i < localRow+3; i++) {
            for(int j = localCol; j < localCol+3; j++) {
                if(board[i][j] == num) return true;
            }
        }
        return false;
    }
    private static boolean isValidPlacement(char[][] board, char num, int row, int col) {
        return !isNumberInRow(board, num, row) && !isNumberInColumn(board, num, col) && !isNumberInBox(board, num, row, col);
    }
    private static boolean solveBoard(char[][] board) {
        for(int row = 0; row < GRID_SIZE; row++) {
            for(int col = 0; col < GRID_SIZE; col++) {
                if(board[row][col] == '.') {
                    for(int tryNum = 1; tryNum <= GRID_SIZE; tryNum++) {
                        if(isValidPlacement(board, (char)(tryNum+'0'), row, col)) {
                            board[row][col] = (char)(tryNum+'0');
                            if(solveBoard(board)) return true;
                            else {
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}