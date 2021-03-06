// sliding window
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0, j = 0; j < s.length(); j++){
            if (map.containsKey(s.charAt(j))){
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            map.put(s.charAt(j), j);
            max = Math.max(max, j-i+1);
        }
        return max;
    }
}