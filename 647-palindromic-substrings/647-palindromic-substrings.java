class Solution {    
    public int countSubstrings(String s) {
        int count = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++){
            
            count += isPalindrome(c, i, i);  // odd length
            count += isPalindrome(c, i, i+1);  // even length
        }
        
        return count;
    }
    
    private int isPalindrome(char[] c, int start, int end){
        int count = 0;
        while (start >= 0 && end < c.length && c[start--] == c[end++]){
            count++;
        }
        return count;
    }
}