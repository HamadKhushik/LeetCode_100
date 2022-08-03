class Solution {
    public int maxProduct(int[] nums) {
        int total_max = nums[0];
        int curr_max = nums[0];
        int curr_min = nums[0];
        
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < 0){
                int temp = curr_max;
                curr_max = curr_min;
                curr_min = temp;
            }
            
            curr_max = Math.max(nums[i], nums[i]*curr_max);
            curr_min=  Math.min(nums[i], nums[i]*curr_min);
            total_max = Math.max(total_max, curr_max);
        }
        return total_max;
    }
}