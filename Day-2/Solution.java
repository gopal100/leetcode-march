/*
https://leetcode.com/problems/is-subsequence/

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

*/

class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s== null || s.equals(""))
            return true;
        else if(s.length()==1 && t.length() ==1){
            if(s.equalsIgnoreCase(t))
               return true;
            else
                return false;
        }
        
        int startIdx = 0;
        boolean isSubsequence = false;
        
        for(int i=0; i<t.length(); i++){
            if(s.charAt(startIdx) == t.charAt(i)){
                startIdx++;
            }
            if(startIdx==s.length()){
                isSubsequence = true;
                break;
            }
        }
        return isSubsequence;
    }
}