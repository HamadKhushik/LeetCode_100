class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        
        for (int num : nums){
            sum = Math.max(sum + num, num);
            max = Math.max(max, sum);
        }
        return max;
    }
}