class Solution {
    int lo;
    int maxLength;
    
    public String longestPalindrome(String s) {
        int len = s.length();
        String s3 = "";
        if (len < 2){
            return s;
        }
        for(int i = 0; i < len-1; i++){
            palindrome(s, i, i);  // if string length is odd
            palindrome(s, i, i+1);  // if string length is even
            
        }
        return s.substring(lo, lo + maxLength);
    }
    
    private void palindrome(String s, int j, int k){
        
        while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }
        if (maxLength < k - j -1){
            lo = j + 1;
            maxLength = k - j - 1;
        }
        
    }
}