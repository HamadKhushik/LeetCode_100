class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);

        }
        
        List<Integer>[] list = new List[nums.length + 1];
        
        for (int key : map.keySet()){
            int frequency = map.get(key);
            if (list[frequency] == null){
                list[frequency] = new ArrayList<>();
            }
            list[frequency].add(key);
        }
        
       List<Integer> res = new ArrayList<>();
        
        for (int i = list.length-1; i>= 0 && res.size() < k; i--){
            if (list[i] != null){
                res.addAll(list[i]);
            }
        }
        int[] result = res.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
        return result;
    }
}