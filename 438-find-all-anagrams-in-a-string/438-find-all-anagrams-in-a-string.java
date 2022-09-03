class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        
        if (p.length() > s.length()){
            return result;
        }
        
        // built frequency map
        for (char ch : p.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int start = 0; 
        int end = 0;
        int counter = map.size();
        
        while (end < s.length()){
            char c = s.charAt(end);
            if (map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0){
                    counter--;
                }
            }
            end++;
            
            // when all the chars in p has been discovered by 'end'
            while (counter == 0){
                char tempc = s.charAt(start);
                if (map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0){
                        counter++;
                    }
                }
                
                if (end - start == p.length()){
                    result.add(start);
                }
                start++;
            }
        }
        return result;
    }
}