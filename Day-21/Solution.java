/*
https://leetcode.com/problems/partition-labels/
763. Partition Labels

*/

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] freq = new int[26];
        Set<Character> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        
        if(s== null || s.equals(""))
            return list;
        
        for(int i =0; i<s.length(); i++){
            freq[s.charAt(i)-'a']++;
        }
        int count = 0;
        for(int i =0; i<s.length(); i++){
            set.add(s.charAt(i));
            count++;
            freq[s.charAt(i)-'a']--;
            
            if(freq[s.charAt(i)-'a'] == 0){
                set.remove(s.charAt(i));
                if(set.isEmpty()){
                    list.add(count);
                    count = 0;
                }
            }
        }
        
        return list;        
    }
}