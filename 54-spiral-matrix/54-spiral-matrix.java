class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> list = new ArrayList<>();
        int beginRow = 0; 
        int beginCol = 0;
        int endRow = matrix.length -1;
        int endCol = matrix[0].length - 1;
        
        while (beginRow <= endRow && beginCol <= endCol){
            // move right
            for (int i = beginCol; i <= endCol; i++){
                list.add(matrix[beginRow][i]);
            }
            beginRow++;
            
            // move down
            for (int i = beginRow; i <= endRow; i++){
                list.add(matrix[i][endCol]);
            }
            endCol--;
            
            // move left
            if (beginRow <= endRow){    // check to ensure cells are not repeated
                for (int i = endCol; i >= beginCol; i--){
                    list.add(matrix[endRow][i]);
                }
                endRow--;
            }
            
            // move up
            if (beginCol <= endCol){       // check to ensure cells are not repeated
                for (int i = endRow; i >= beginRow; i--){
                    list.add(matrix[i][beginCol]);
                }
                beginCol++;
            }
        }
        return list;
    }
}