public class Solution {
    /* If characters match then we take diagnol and left sum else just take left value*/
    public int numDistinct(String s, String t) {
        if (s.length() == 0)
            return 0;
            
        int[][] DP = new int[t.length() + 1][s.length() + 1];
        
        for (int i = 0; i < DP[0].length; i++)
            DP[0][i] = 1;                
        
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (s.charAt(j - 1) == t.charAt(i - 1))
                    DP[i][j] = DP[i-1][j-1] + DP[i][j-1];
                else
                    DP[i][j] = DP[i][j-1];
            }    
        }
        return DP[t.length()][s.length()];
    }
}