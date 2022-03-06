/*
https://leetcode.com/problems/counting-bits/
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

*/

class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        int num = n;
        String str = null;
        while(num > 0){
            str = Integer.toBinaryString(num);
            //System.out.println("data "+str);
            //long data = ;
            result[num] = (int)str.chars().filter(ch -> ch == '1').count();
            num--;
        }
        return result;
    }
}