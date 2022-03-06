/*
https://leetcode.com/problems/delete-and-earn/

You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.
*/

class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxLen = 0;
        
        for(int i=0; i<nums.length;i++){
            maxLen = Math.max(maxLen, nums[i]);
        }
        
        int[] arr = new int[maxLen+1];
        
        for(int i=0; i<nums.length; i++){
            arr[nums[i]]++;
        }
        
        for(int i=1; i<arr.length;i++){
            arr[i] = Math.max(arr[i-1], (arr[i]*i)+arr[Math.max(i-2, 0)]);
        }
        
        /*for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }*/
        
        return arr[maxLen];
    }
}