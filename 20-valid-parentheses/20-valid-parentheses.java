// for every opening parenthesis, push a corresponding closing paranthesis on the stack. And remove when one is found in the String

class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()){
            
            if (ch == '('){
                stack.push(')');
            } else if (ch == '{'){
                stack.push('}');
            } else if (ch == '['){
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != ch){
                return false;
            }
        }
             return stack.isEmpty();
    }
}