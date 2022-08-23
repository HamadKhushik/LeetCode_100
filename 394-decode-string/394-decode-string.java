class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        String res = "";
        
        while (idx < s.length()){
            
            if (Character.isDigit(s.charAt(idx))){
                int count = 0;
                while (Character.isDigit(s.charAt(idx))){
                    count = 10 * count + s.charAt(idx) - '0';
                    idx++;
                }
                countStack.push(count);
            }
            
            else if (s.charAt(idx) == '['){
                resStack.push(res);
                res = "";
                idx++;
            }
            
            else if (s.charAt(idx) == ']'){
                int repeatTimes = countStack.pop();
                StringBuilder temp = new StringBuilder(resStack.pop());
                for (int i = 0; i < repeatTimes; i++){
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx);
                idx++;
            }
        }
        return res;
    }
}