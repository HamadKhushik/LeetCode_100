class Solution {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(exist(board, i, j, w, 0)){
                    return true;
                }
            }
        }
        return false;
    }
        
        private boolean exist(char[][] board, int x, int y, char[] word, int count){
            if(count == word.length){
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
            boolean exist = exist(board, x+1, y, word, count+1) ||
                            exist(board, x-1, y, word, count+1) ||
                            exist(board, x, y+1, word, count+1) ||
                            exist(board, x, y-1, word, count+1);
            board[x][y] = temp;
            return exist;
        }
}
