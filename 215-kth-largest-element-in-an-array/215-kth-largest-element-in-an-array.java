// quick selection algorithm using the partition method
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        k = nums.length - k;
        int lo = 0; 
        int hi = nums.length - 1;
        shuffle(nums);
        while (lo < hi){
            final int j = partition(nums, lo, hi);
            
            if (j < k){
                lo = j + 1;
            } else if (j > k){
                hi = j - 1; 
            } else {
                break;
            }
        }
        return nums[k];  // j = k as the loop will only break on this condition
    }
    
    private int partition(int[] nums, int lo, int hi){
        int i = lo;
        int j = hi + 1;
        
        while(true){
            while((i < hi) && (nums[++i] < nums[lo]));
            while ((j > lo) && (nums[lo] < nums[--j]));
            if (i >= j){
                break;
            }
            swap(nums, i , j);
        }
        swap(nums, lo, j);
        return j;
    }
    
    private void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    
    private void shuffle(int[] nums){
        final Random random = new Random();
        for (int i = 1; i < nums.length; i++){
            int r = random.nextInt(i + 1);
            swap(nums, i, r);
        }
    }
}