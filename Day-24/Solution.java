/*
https://leetcode.com/problems/boats-to-save-people/
881. Boats to Save People
*/

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i =0;
        int j = people.length-1;
        int result = 0;
        
        while(i<=j){
            if(people[i]+people[j] <= limit){
                i++;
                j--;
            }else{
                j--;
            }
            result++;
        }
        return result;
    }
}