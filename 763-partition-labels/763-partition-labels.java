class Solution {
    public List<Integer> partitionLabels(String s) {
        
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> lastIndex = new HashMap<>();
        
        if (s == null || s.length() == 0){
            return result;
        }
        
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            lastIndex.put(ch, i);
        }
        
        int start = 0; 
        int end = 0;
        for (int i = 0; i < s.length(); i++){
            
            char ch = s.charAt(i);
            end = Math.max(end, lastIndex.get(ch));
            if (i == end){
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}