// Boyer Moore Voting Algorithm

class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 0;
        int ret = 0;
        
        for (int num : nums){
            if (count == 0){
                ret = num;
                count++;
            } else if (ret == num){
                count++;
            } else {
                count--;
            }
        }
        return ret;
    }
}