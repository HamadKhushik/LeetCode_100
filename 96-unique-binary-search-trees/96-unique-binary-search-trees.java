// Iterative solution based on catalan number calculation
// using this formula: G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0) 

class Solution {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        
        G[0] = G[1] = 1;
        
        for (int i = 2; i <= n; i++){
            for (int j = 1; j <= i; j++){
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}