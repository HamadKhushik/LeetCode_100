class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void backtrack(int[] candidates, int start, int remaining, List<Integer> current, List<List<Integer>> result){
        if (remaining < 0){
            return;
        } else if (remaining == 0){
            result.add(new ArrayList<Integer>(current));
        } else {
            for (int i = start; i < candidates.length && candidates[i] <= remaining; i++){
                current.add(candidates[i]);
                backtrack(candidates, i, remaining - candidates[i], current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}