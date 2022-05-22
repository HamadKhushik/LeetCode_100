class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1){
            return;
        }
        
        int i = nums.length-1;
        while (i > 0 && nums[i - 1] >= nums[i]){
            i--;
        }
        if (i <= 0){
            sort(nums, 0, nums.length - 1);
            return;
        }
        
        int j = nums.length-1;
        while (nums[j] <= nums[i - 1]){
            j--;
        }
        
        int temp = nums[i - 1];
        nums[i - 1] = nums[j];
        nums[j] = temp;
        
        // sort the suffix in ascending order
        j = nums.length-1;
        sort(nums, i, j);
        return;
    }
    
    private void sort(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}