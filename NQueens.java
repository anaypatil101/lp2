import java.util.*;

public class NQueens {
    private boolean isSafe(int row, int col, char[][] board) {
        int r = row, c = col;
        // upper left diagonal
        while(r >= 0 && c >= 0) {
            if(board[r][c] == 'Q')  
                return false;

            r--;
            c--;
        }

        r = row;
        c = col;

        // up
        while(r >= 0) {
            if(board[r][c] == 'Q') 
                return false;

            r--;
        }

        r = row;
        c = col;

        // right diagonal
        while(r >=0 && c < board.length) {
            if(board[r][c] == 'Q')
                return false;

            r--;
            c++;
        }
        return true;

    }
    private void func(int row, char[][] board, List<List<String>> ans) {
        if(row == board.length) {
            List<String> solution = new ArrayList<>();
            for(char[] r : board) 
                solution.add(new String(r));
            
            ans.add(solution);
            return;
        }
        // for each column
        for(int col=0; col<board[0].length; col++) {
            if(isSafe(row, col, board)) {
                board[row][col] = 'Q';
                func(row+1, board, ans);
                board[row][col] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for(char[] row : board) Arrays.fill(row, '.');

        func(0, board, ans);
        return ans;
    }
    public static void main(String[] args) {
        NQueens p = new NQueens();
        List<List<String>> ans = p.solveNQueens(4);

        for(List<String> row : ans) {
            for(String str : row) {
                System.out.println(str);
            }
            System.out.println();
        }
    }
}
