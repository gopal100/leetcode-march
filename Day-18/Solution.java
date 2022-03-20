/*
https://leetcode.com/problems/remove-duplicate-letters/
Remove Duplicate Letters
*/

class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] visited = new boolean[26];
        int[] freq = new int[26];
        
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i)-'a']++;
        }
        StringBuilder res = new StringBuilder("");
        
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i)-'a']--;
            
            if(visited[s.charAt(i)-'a'] == false){
                int len = res.length();
                if(len > 0){
                    while(len > 0 && res.charAt(len-1) > s.charAt(i)
                            && freq[res.charAt(len-1)-'a'] > 0){
                        visited[res.charAt(len-1)-'a'] = false;
                        res = res.deleteCharAt(len-1);
                        len--;
                    }
                    visited[s.charAt(i)-'a']= true;
                    res.append(s.charAt(i));
                }else{
                    res.append(s.charAt(i));
                    visited[s.charAt(i)-'a'] = true;
                }
            }
        }
        
        return res.toString();
    }
}