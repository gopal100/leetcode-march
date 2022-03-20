/*
https://leetcode.com/problems/score-of-parentheses/
Score of Parentheses
*/

class Solution {
    public int scoreOfParentheses(String s) {
        int score =0;
        Stack<String> stack = new Stack<>();
        char[] input = s.toCharArray();
        for(int i=0; i< s.length(); i++){
            if(input[i] == '('){
                stack.push(String.valueOf(input[i]));
            }else{
                if(Objects.equals(stack.peek(), "(")){
                    stack.pop();
                    stack.push("1");
                }else{
                    int data = 0;
                    while(!Objects.equals(stack.peek(), "(")){
                        data += Integer.parseInt(stack.pop());
                    }
                    stack.pop();
                    data = 2*data;
                    stack.push(String.valueOf(data));
                }
            }
        }
        while (!stack.isEmpty())
            score += Integer.parseInt((stack.pop()));
        return score;
    }
}