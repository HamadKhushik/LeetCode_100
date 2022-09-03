class Solution {
    int count = 0;
    
    public int countSubstrings(String s) {
        
        for (int i = 0; i < s.length(); i++){
            
            isPalindrome(s, i, i);  // odd length
            isPalindrome(s, i, i+1);  // even length
        }
        
        return count;
    }
    
    private void isPalindrome(String s, int start, int end){
        
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            count++;
            start--;
            end++;
        }
    }
}