class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        
        int[] temp = intervals[0];
        for (int[] interval : intervals){
            if (temp[1] >= interval[0]){
                temp[1] = Math.max(temp[1], interval[1]);
            } else {
                result.add(temp);
                temp = interval;
            }
        }
        result.add(temp);
        return result.toArray(new int[result.size()][]);
    }
}