// DP solution

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] flags = new boolean[s.length() + 1];
        flags[0] = true;
        
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(flags[j] && set.contains(s.substring(j, i))){
                    flags[i] = true;
                    break;
                }
            }
        }
        return flags[s.length()];
    }
}