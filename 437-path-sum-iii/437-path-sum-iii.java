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
    int total = 0;
 public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        if(root==null)return 0;
        map.put(0L,1);
        findPathSum(root , map , targetSum , 0L);
        return total;
        
    }
    
    private void findPathSum(TreeNode root , HashMap<Long,Integer>map, int target , long currSum){
        if(root==null)return;
        currSum+=root.val;
        if(map.containsKey(currSum-target)){
            int temp =  map.get(currSum-target);
            total+=temp;
        }
        map.put(currSum , map.getOrDefault(currSum , 0)+1);
        findPathSum(root.left , map , target , currSum);
        findPathSum(root.right , map , target , currSum);
        map.put(currSum , map.get(currSum)-1);
        return ;
    }
}