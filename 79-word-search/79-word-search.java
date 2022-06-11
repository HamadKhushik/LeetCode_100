class Solution {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if(exist(board, w, i , j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean exist(char[][] board, char[] word, int x, int y, int count){
        if (count == word.length){
            return true;
        }
        
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length){
            return false;
        }
        
        if (board[x][y] != word[count]){
            return false;
        }
        
        char temp = board[x][y];
        board[x][y] = ' ';
        
        if (exist(board, word, x + 1, y, count + 1) || 
                 exist(board, word, x - 1, y, count + 1) ||
                 exist(board, word, x, y + 1, count + 1) ||
                 exist(board, word, x, y - 1, count  +1)){
            return true;
        }
        board[x][y] = temp;
        return false;
    }
}
