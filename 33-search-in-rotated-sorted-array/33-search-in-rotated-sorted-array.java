class Solution {
    public int search(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;
        
        // modified Binary search to find the pivot in the array
        while (left < right){
            int mid = left + (right - left ) /2;
            if (nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        int start = left;
        left = 0;
        right = nums.length - 1;
        
        if (target >= nums[start] && target <= nums[right]){
            left = start;
        }
        else{
            right = start;
        }
        
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (target == nums[mid]){
                return mid;
            } else if (target < nums[mid]){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}