// Backtracking

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recurse(result, "", 0, 0, n);
        return result;
    }
    
    private void recurse(List<String> result, String current, int open, int closed, int max){
        if (current.length() == 2 * max ){
            result.add(current);
            return;
        }
        
        if (open < max){
            recurse(result, current + "(", open + 1, closed, max);
        }
        
        if (closed < open){
            recurse(result, current + ")", open, closed + 1, max);
        }
    }
}