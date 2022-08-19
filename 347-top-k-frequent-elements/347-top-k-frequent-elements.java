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
        
        int[] result = new int[k];
        int index = 0;
        
        for (int i = list.length-1; i>= 0 && index < k; i--){
            if (list[i] != null){
                for (int j : list[i]){
                    result[index++] = j;
                }
                //res.addAll(list[i]);
            }
        }
        
        // convert the list in an array for compatible return type
        // int[] result = res.stream()
        //                 .mapToInt(Integer::intValue)
        //                 .toArray();
        return result;
    }
}