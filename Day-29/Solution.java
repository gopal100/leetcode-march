/*
https://leetcode.com/problems/find-the-duplicate-number/
287. Find the Duplicate Number

*/

class Solution {
    public int findDuplicate(int[] nums) {
        
        /*int sum = 0;
        
        for(int i : nums){
            sum += i;
        }
        int len = nums.length;
        int total = ((len-1)*len)/2;
        
        return sum - total;
        
        */
        int slow = nums[0];
        int fast = nums[0];
        
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
            
        }while(slow!=fast);
        
        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}a