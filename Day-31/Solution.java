/*
https://leetcode.com/problems/split-array-largest-sum/
410. Split Array Largest Sum

*/

class Solution {
    public int splitArray(int[] nums, int m) {
        int sum = 0;
        int maxnum = nums[0];
        for(int n : nums){
            sum+= n;
            maxnum = Math.max(maxnum, n);
        }
        
        int res = sum;
        int l = maxnum, r = sum;
        //System.out.println(maxnum + "    "+sum);
        while(l <= r){
            int mid = (l +r)/2;
            if(canSplit(mid, nums, m)){
                res = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }            
        }
        
        return res;
    }
    
    private boolean canSplit(int num, int[] nums, int m){
        int subArraycnt = 0;
        int sum = 0;
        for(int n: nums){
            sum += n;
            if(sum > num){
                subArraycnt++;
                sum =n;
            }
        }
        
        return subArraycnt+1 <= m;
        
    }
}