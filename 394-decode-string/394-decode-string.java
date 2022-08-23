// using StringBuilder instead of String for better performance

class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resStack = new Stack<>();
        int idx = 0;
        StringBuilder res = new StringBuilder();
        
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
                res = new StringBuilder();
                idx++;
            }
            
            else if (s.charAt(idx) == ']'){
                int repeatTimes = countStack.pop();
                StringBuilder temp = resStack.pop();
                for (int i = 0; i < repeatTimes; i++){
                    temp.append(res);
                }
                res = temp;
                idx++;
            }
            else {
                res.append(s.charAt(idx));
                idx++;
            }
        }
        return res.toString();
    }
}