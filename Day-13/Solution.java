/*
https://leetcode.com/problems/valid-parentheses/
20. Valid Parentheses

*/

class Solution {
    public boolean isValid(String s) {
        char[] ch=s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for(char c: ch){
            if(stack.isEmpty()){
                stack.push(c);
            }else{
                char fetched = stack.pop();
                if(c == ')' && fetched == '('){
                    continue;
                }else if(c == '}' && fetched == '{'){
                    continue;
                }else if(c == ']' && fetched == '['){
                    continue;
                }
                else{
                    stack.push(fetched);
                    stack.push(c);
                }
            }
        }
        
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}