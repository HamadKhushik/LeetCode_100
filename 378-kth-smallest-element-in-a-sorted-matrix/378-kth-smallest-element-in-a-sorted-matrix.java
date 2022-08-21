// Binary Search approach

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        int min = matrix[0][0];
        int max = matrix[n-1][n-1];
        
        while (min < max){
            int mid = min + (max - min)/2;
            int count = countLessOrEqual(matrix, mid);
            if (count < k){
                min = mid + 1;
            } else {
                max = mid;
            } 
        }
        return min;
    }
    
    private int countLessOrEqual(int[][] matrix, int mid){
        int row = 0;
        int col = matrix[0].length-1;
        int n = matrix.length;
        int count = 0;
        
        while (row >= 0 && row < n && col >= 0 && col < n){
            if (matrix[row][col] <= mid ){
                count += col + 1;
                row++;
            } else {
                col--;
            }
        }
        return count;
    }
}