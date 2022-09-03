class Solution {    
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            
            count += isPalindrome(s, i, i);  // odd length
            count += isPalindrome(s, i, i+1);  // even length
        }
        
        return count;
    }
    
    private int isPalindrome(String s, int start, int end){
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            count++;
            start--;
            end++;
        }
        return count;
    }
}