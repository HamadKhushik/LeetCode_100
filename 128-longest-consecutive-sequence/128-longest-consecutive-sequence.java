class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        
        for (int num : nums){
            if(map.containsKey(num))
                continue;
            
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            int sum = left + right + 1;
            
            res = Math.max(sum, res);
            
            if (left > 0)
                map.put(num - left, sum);
            if(right > 0)
                map.put(num + right, sum);
            map.put(num, sum);
        }
        return res;
    }
}