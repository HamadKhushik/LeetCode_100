// using Monotnic Stack - decreasing monotonic stack
// using array as a stack, keeping track of the top index


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] result = new int[temperatures.length];
        int[] stack = new int[temperatures.length];
        int top = -1;   // keeps track of the current top(last used) index in array
        
        for (int i = 0; i < temperatures.length; i ++){
            
            while (top >= 0 && temperatures[i] > temperatures[stack[top]]){
                int idx = stack[top--];
                result[idx] = i - idx;
            }
            
            stack[++top] = i;
        }
        return result;
    }
}