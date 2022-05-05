// one pass HashMap. insert elements in the array as keys in the map and indices as values. if compliment is found in the map, return the values

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++){
             int compliment = target - nums[i];
            if (map.containsKey(compliment)){
                return new int[]{map.get(compliment), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}