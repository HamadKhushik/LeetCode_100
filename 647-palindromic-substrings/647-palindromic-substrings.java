// if total number of elements in an array is odd, mid is i(one element)
// if total number of elements in an array is even, mid is i &  i +1 (two elements)

class Solution {    
    public int countSubstrings(String s) {
        
        int count = 0;
        char[] c = s.toCharArray();
        
        for (int i = 0; i < s.length(); i++){
            
            count += isPalindrome(c, i, i);  // odd
            count += isPalindrome(c, i, i+1);  // even
        }
        return count;
    }
    
    private int isPalindrome(char[] c, int start, int end){
        int count = 0;
        // if c[start] == c[end], expand in both directions
        while (start >= 0 && end < c.length && c[start--] == c[end++]){
            count++;
        }
        return count;
    }
}