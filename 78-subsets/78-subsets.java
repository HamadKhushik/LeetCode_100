class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), 0, nums);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> list, int start, int[] nums){
        result.add(new ArrayList<>(list));
        
        for (int i = start; i < nums.length; i++){
            list.add(nums[i]);
            backtrack(result, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }
}