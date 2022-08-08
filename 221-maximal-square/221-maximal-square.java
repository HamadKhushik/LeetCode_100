class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length; 
        int column = matrix[0].length; 
        
        int[][] dp = new int[row + 1] [column + 1];
        int result = 0; 
        
        for (int i = 1; i <= row; i++){
            for (int j = 1; j <= column; j++){
                if (matrix[i - 1][j - 1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1] , dp[i - 1][j - 1]), dp[i - 1][j]) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result * result;
    }
}