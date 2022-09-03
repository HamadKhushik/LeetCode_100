// simple and fast solution using an array as a map
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        int[] frequency = new int[26];  // 26 characters in alphabet
        
        if (p.length() > s.length()){
            return result;
        }
        
        for (char ch : p.toCharArray()){
            frequency[ch - 'a']++;
        }
        
        int counter = p.length();
        int start = 0;
        int end = 0;
        
        for (end = 0; end < p.length(); end++){
            char ch = s.charAt(end);
            frequency[ch - 'a']--;
            if (frequency[ch - 'a'] >= 0){
                counter--;
            }
        }
        
        if (counter == 0){
            result.add(start);
        }
        
        while (end < s.length()){
            char ch = s.charAt(start);
            if (frequency[ch - 'a'] >= 0){
                counter++;
            }
            frequency[ch - 'a']++;
            start++;
            
            ch = s.charAt(end);
            frequency[ch - 'a']--;
            if (frequency[ch - 'a'] >= 0){
                counter--;
            }      
            end++;
            
            if (counter == 0){
                result.add(start);
            }
        }
        return result;
    }
}









