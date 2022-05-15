// solution without instance variables
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        String s3 = "";
        if (len < 2){
            return s;
        }
        for(int i = 0; i < len-1; i++){
            String s1 = palindrome(s, i, i);  // if string length is odd
            String s2 = palindrome(s, i, i+1);  // if string length is even
            
            if (s1.length() > s3.length()){ s3 = s1;}
            if (s2.length() > s3.length()){ s3 = s2;}
        }
        return s3;
    }
    
    private String palindrome(String s, int j, int k){
        
        while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }
        return s.substring(j+1, k);
    }
}