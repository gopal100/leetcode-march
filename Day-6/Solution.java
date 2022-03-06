/*
https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/

Count All Valid Pickup and Delivery Options
---------------------------------
Given n orders, each order consist in pickup and delivery services. 

Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i). 

Since the answer may be too large, return it modulo 10^9 + 7.

*/

class Solution {
    public int countOrders(int n) {
                
        double[] dp = new double[n+1];
        dp[0] = 1;
        double mod = Math.pow(10,9)+7;
        
        for(int i=1; i<=n; i++){
            dp[i] = i*dp[i-1]*(2*i-1);
            dp[i] = dp[i]%mod;
        }
        
        return (int)dp[n];
    }
}