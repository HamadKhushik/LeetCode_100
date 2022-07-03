class Solution {
    private Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length() + 1];
        return dfs(s, 0, 0, new HashSet(wordDict));
    }
    
    private boolean dfs(String s, int i, int j, Set<String> set){
        if(j == s.length()) return i == j ? true : set.contains(s.substring(i, j));
        
        if(memo[i] != null) return memo[i];
        
        if(set.contains(s.substring(i, j + 1)) && dfs(s, j + 1, j + 1, set)) 
            return memo[i] = true;
            
        return memo[i] = dfs(s, i, j + 1, set);
    }
}