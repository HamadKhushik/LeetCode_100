class Solution {
    public void sortColors(int[] nums) {
        
        int min = 0; 
        int equal = 0;
        int max = nums.length-1; 
        
        while (equal <= max){
            
            switch(nums[equal]){
                    
                case 0:
                    swap(nums, min, equal);
                    min++;
                    equal++;
                    break;
                    
                case 1:
                    equal++;
                    break;
                    
                case 2:
                    swap(nums, equal, max);
                    max--;
                    break;
                
            }
        }
    }
    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}