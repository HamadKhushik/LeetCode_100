/* SnowBall Method
 public void moveZeroes(int[] nums) {
        
        int snowBall = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                snowBall++;
            } else if (snowBall > 0){
                int t = nums[i];
                nums[i] = 0;
                nums[i - snowBall] = t;
            }
        }
    }
*/

class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;  // tracks the position of next non-zero element
        
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}