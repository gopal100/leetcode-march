/*
https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
1249. Minimum Remove to Make Valid Parentheses
*/

class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for(char ch : arr){
            if(stack.isEmpty() && ch == ')'){
                continue;
            }else if(ch >= 'a' && ch <= 'z'){
                continue;
            }else{
                if(!stack.isEmpty()){
                    char top= stack.peek();
                    if(top == '(' && ch == ')'){
                        sb.append(ch);
                        sb.append(top);
                        stack.pop();
                        continue;
                    } else if(top == '(')
                        stack.push('(');
                }else{
                    if(ch == '(')
                        stack.push('(');
                }

            }
        }
        
        int openB = 0, closeB = 0;
        for(char ch : arr){
            if(ch >= 'a' && ch <= 'z'){
                result.append(ch);
            }
            else if(ch == ')' && result.indexOf("(") == -1)
                continue;
            else if((ch == '(' || ch == ')') && sb.length() > 0){
                int idx = sb.indexOf(String.valueOf(ch));
                if(idx != -1){
                    if(ch == '(')
                        openB++;
                    if(ch == ')')
                        closeB++;
                    if(closeB > openB){
                        closeB--;
                        continue;
                    }
                    result.append(sb.charAt(idx));
                    sb.deleteCharAt(idx);
                }
                
            }
        }
        return result.toString();
    }
}