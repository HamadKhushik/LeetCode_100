class Solution {
    public List<Integer> findAnagrams(String s, String p) {
                
        List<Integer> result = new ArrayList<>();
        int[] frequency = new int[26];
        
        if (p.length() > s.length()){
            return result;
        }
        
        for (char ch : p.toCharArray()){
            frequency[ch - 'a']++;
        }
        
        int start = 0;
        int end = 0;
        int len = p.length();
        int counter = len;
        
        for (end = 0; end < len; end++){
            char temp = s.charAt(end);
            frequency[temp - 'a']--;
            if (frequency[temp - 'a'] >= 0){
                counter--;
            }
        }
        
        if (counter == 0){
            result.add(start);
        }
        
        while (end < s.length()){
            char temp = s.charAt(start);
            if (frequency[temp - 'a'] >= 0){
                counter++;
            }
            frequency[temp - 'a']++;
            start++;
            
            temp = s.charAt(end);
            frequency[temp - 'a']--;
            if (frequency[temp - 'a'] >= 0){
                counter--;
            }
            
            if (counter == 0){
                result.add(start);
            }
            end++;
        }
        return result;
    }
}