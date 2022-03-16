/*
https://leetcode.com/problems/validate-stack-sequences/
946. Validate Stack Sequences
*/

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i =0, j =0;
        
        for(i =0; i< pushed.length; i++){
            stack.push(pushed[i]);
            while(stack.size() > 0 && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}