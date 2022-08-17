// DP iterative solution

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        
        int sum = 0;
        
        while(++sum <= amount){
            int min = -1;
            for (int coin : coins){
                if(sum >= coin &&  dp[sum - coin] != -1){
                    int temp = dp[sum - coin] + 1;
                    if (min < 0 || temp < min){
                        min = temp;
                    }
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }
}