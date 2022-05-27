// starting from the last index

class Solution {
    public boolean canJump(int[] nums) {
        int lastValidIndex = nums.length - 1;
        
        for (int i = nums.length - 1; i>=0; i--){
            if (i + nums[i] >= lastValidIndex){
                lastValidIndex = i;
            }
        }
        return lastValidIndex == 0;
    }
}