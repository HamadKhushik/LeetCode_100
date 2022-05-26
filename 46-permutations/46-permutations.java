// Backtracking

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        backtrack(result, new ArrayList<>(), set, nums);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> current, Set<Integer> set, int[] nums){
        if (current.size() == nums.length){
            result.add(new ArrayList(current));
        } else {
            for (int i = 0; i < nums.length; i++ ){
                if (set.contains(nums[i])){
                    continue;
                }
                current.add(nums[i]);
                set.add(nums[i]);
                backtrack(result, current, set, nums);
                current.remove(current.size() - 1);
                set.remove(nums[i]);
            }
        }
    }
}