public class Solution {
    int count = 0;
  
    public int totalNQueens(int n) {
        /* Stores number of columns */
        int[] columns = new int[n];
        Arrays.fill(columns, -1);
        int row = 0;
        
        findPositions(columns, row, n);
        return count;
    }
    
    public void findPositions(int[] columns, int row, int n) {
        if (row == n){
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(columns, row, col)) {
                columns[row] = col;
                findPositions(columns, row + 1, n);
            }
        }
    }
    
    public boolean isSafe(int[] columns, int row, int col) {
        
        for (int i = 0; i < row; i++) {
            int column = columns[i];
            
            // Checks if there is anything in the same row
            if (column == col)
                return false;
                
            /* To check if there is a queen placed in the same diagonal
             * We need to check if diff bw rows and col is same then it is diagonal
             */
            if (Math.abs(row - i) == Math.abs(column - col))
                return false;
        }
        return true;
    }
    
}