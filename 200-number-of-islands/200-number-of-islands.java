class Solution {
    public int numIslands(char[][] grid) {
        
        int numIslands = 0;
        if (grid == null || grid.length == 0){
            return numIslands;
        }
        
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == '1'){
                    numIslands++; 
                    doBFS(grid, i, j);
                }
            }
        }
        return numIslands;
    }
    
    private void doBFS(char[][] grid, int row, int column){
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[row].length || grid[row][column] == '0'){
            return;
        }
        
        grid[row][column] = '0';
        doBFS(grid, row + 1, column);
        doBFS(grid, row - 1, column);
        doBFS(grid, row, column + 1);
        doBFS(grid, row, column - 1);
    }
}