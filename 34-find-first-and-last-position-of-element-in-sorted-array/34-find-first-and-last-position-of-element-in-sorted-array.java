// slightly modified version of Binary Search

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findLeftMost(nums, target);
        result[1] = findRightMost(nums, target);
        
        return result;
    }
    
    private int findLeftMost(int[] nums, int target){
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                index = mid;
            }
            
            if (nums[mid] >= target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
    
    private int findRightMost(int[] nums, int target){
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                index = mid;
            }
            
            if (nums[mid] <= target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}