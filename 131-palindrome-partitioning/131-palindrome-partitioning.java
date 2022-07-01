class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        return backtrack(result, new ArrayList<String>(), s, 0);
    }
    
    private List<List<String>> backtrack(List<List<String>> result, List<String> tempList, String s, int start){
        if (start == s.length())
            result.add(new ArrayList<String>(tempList));
        
        for (int i = start; i < s.length(); i++){            
            if(isPalindrome(s, start, i)){
                tempList.add(s.substring(start, i + 1));
                backtrack(result, tempList, s, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
        return result;
    }
    
    private boolean isPalindrome(String s, int start, int end){
        
        while (start < end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}