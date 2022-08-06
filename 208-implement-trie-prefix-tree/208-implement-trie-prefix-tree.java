class Trie {
    
    private TrieNode root;
    
    public Trie() {    
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            
            if (node.links[ch - 'a'] == null){
                node.links[ch - 'a'] = new TrieNode(ch);
            }
            node = node.links[ch - 'a'];
        }
        node.isWord = true;
    }
    
    
    public boolean search(String word) {
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if (node.links[ch - 'a'] != null){
                node = node.links[ch - 'a'];
            } else {
                return false;
            }
        }
        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        
        for (int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if (node.links[ch - 'a'] != null){
                node = node.links[ch - 'a'];
            } else {
                return false;
            }
        }
        return true;
    }
    
    private class TrieNode {
        char val;
        boolean isWord;
        TrieNode[] links = new TrieNode[26];
        
        private TrieNode(){}
        private TrieNode(char c){
            TrieNode node = new TrieNode();
            node.val = c;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */