class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];  // to store the number of 1's in each 0<= i <= n
        result[0] = 0;
        for (int i = 1; i <= n; i++){
            result [i] = result[i/2] + i%2;  // if 'i' is even then number of 1's = numbers of 1's in 'i/2'. if 'i' is odd                                                  then number of 1's = number of 1's in 'i/2' +'1'
        }
        return result;
    }
}