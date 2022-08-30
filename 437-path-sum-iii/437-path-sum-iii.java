/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = 0;
    
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        helper(root, 0, targetSum, map);
        return count;
 }
    
    private void helper(TreeNode root, long currSum, int target, HashMap<Long, Integer> map){
        
        if (root == null){
            return;
        }
        
        currSum += root.val;
        
        if (map.containsKey(currSum - target)){
            count += map.get(currSum - target);
        }
        
        if (map.containsKey(currSum)){
            map.put(currSum, map.get(currSum) + 1);
        } else {
            map.put(currSum, 1);
        }
        
        helper(root.left, currSum, target, map);
        helper(root.right, currSum, target, map);
        map.put(currSum, map.get(currSum) - 1);
    }
}