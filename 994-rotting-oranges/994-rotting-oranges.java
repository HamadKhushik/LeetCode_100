class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 ){
            return 0;
        }
        
        Queue<int[]> queue = new LinkedList<int[]>();
        int freshCount = 0;
        
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 2){
                    int[] point = new int[]{i, j};
                    queue.offer(point);
                } else if (grid[i][j] == 1){
                    freshCount++;
                }
            }
        }
        
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // total number of minutes
        int count = 0; 
        
        while (!queue.isEmpty() && freshCount > 0){
            int size = queue.size();
            count++;
            
            for (int i = 0; i < size; i++){
                int[] point = queue.poll();
                for (int[] dir : dirs){
                    int row = point[0] + dir[0];
                    int col = point[1] + dir[1];
                    
                    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0 || grid[row][col] == 2){
                        continue;
                    }
                    grid[row][col] = 2;
                    queue.offer(new int[]{row, col});
                    freshCount--;
                }
            }

        }
        return freshCount == 0 ? count : -1;
    }
}