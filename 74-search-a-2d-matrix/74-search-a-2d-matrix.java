class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
        int columns = matrix[0].length-1;
        int row = 0;
        
        while (row < rows && columns >= 0){
            if (matrix[row][columns] == target){
                return true;
            } else if (matrix[row][columns] > target){
                columns--;
            } else {
                row++;
            }
        }
        return false;
    }
}