public class Solution {
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        int[] columns = new int[n];
        Arrays.fill(columns, -1);
        int row = 0;
        
        findPositions(columns, row, n, result);
        return result;
    }
    
    public void findPositions(int[] columns, int row, int n, List<List<String>> result) {
        if (row == n){
            addResult(columns, result);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(columns, row, col)) {
                columns[row] = col;
                findPositions(columns, row + 1, n, result);
            }
        }
    }
    
    public void addResult(int[] columns, List<List<String>> result) {
        List<String> res = new ArrayList<String>();
        
        for( int i = 0; i < columns.length; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < columns.length; j++) {
                temp.append(".");
            }
            temp.setCharAt(columns[i], 'Q');
            res.add(temp.toString());
        }
        result.add(res);
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