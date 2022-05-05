// solution based on Fibonaci series

class Solution {
    public int climbStairs(int n) {
        
        if (n <= 1){
            return 1;
        }
        int[] distinctWays = new int[n + 1];
        distinctWays[1] = 1;
        distinctWays[2] = 2;
        
        for (int i = 3; i <= n; i++){
            distinctWays[i] = distinctWays[i-1] + distinctWays[i-2];
        }
        return distinctWays[n];
    }
}