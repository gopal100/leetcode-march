/*
https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
1007. Minimum Domino Rotations For Equal Row
*/

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int top = tops[0];
        int buttom = bottoms[0];
        int missingTop =0, missingButtom = 0;
        int[] arr = new int[]{top, buttom};
        int res = Integer.MAX_VALUE;
        for(int num : arr){
            missingTop = 0;
            missingButtom = 0;
            for(int i=0, j=0; i<=tops.length; i++, j++){
                if(tops[i] != num && bottoms[i] != num){
                    break;
                }
                if(tops[i] != num)
                    missingTop++;
                if(bottoms[i] != num)
                    missingButtom++;
                
                if(i == tops.length-1){
                    int missingCnt = Math.min(missingTop, missingButtom);
                    res = Math.min(res, missingCnt);
                    break;
                }
                  
            }
        }
        if(res != Integer.MAX_VALUE)
            return res;
        
        return -1;
        
    }
}