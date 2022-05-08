class Solution {
    public int maxProfit(int[] arr) {
        
        int minPrice = Integer.MAX_VALUE;
        int op = 0;
        int pist = Integer.MIN_VALUE;  // profit if sold today
        
        for (int num : arr){
            minPrice = Math.min(minPrice, num);
            pist = num - minPrice;
            op = Math.max(op, pist);
        }
        return op;
    }
}