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
    
    private void doBFS(char[][] grid, int start, int end){
        if (start < 0 || start >= grid.length || end < 0 || end >= grid[start].length || grid[start][end] == '0'){
            return;
        }
        
        grid[start][end] = '0';
        doBFS(grid, start + 1, end);
        doBFS(grid, start - 1, end);
        doBFS(grid, start, end + 1);
        doBFS(grid, start, end - 1);
    }
}