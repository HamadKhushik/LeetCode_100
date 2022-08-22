class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int index = 0;
        String res = "";
        
        while (index < s.length()){
            
            if (Character.isDigit(s.charAt(index))){
                int count = 0;
                while (Character.isDigit(s.charAt(index))){
                    count = 10 * count + s.charAt(index) - '0';
                    index++;
                }
                countStack.push(count);
            }
            
            else if (s.charAt(index) == '['){
                resStack.push(res);
                res = "";
                index++;
            }
            else if (s.charAt(index) == ']'){
                StringBuilder temp = new StringBuilder(resStack.pop());
                int times = countStack.pop();
                for (int i = 0; i < times; i++){
                    temp.append(res);
                }
                index++;
                res = temp.toString();
            }
            else {
                res += s.charAt(index);
                index++;
            }        
        }
        return res;
    }
}