/*
https://leetcode.com/problems/search-a-2d-matrix/
74. Search a 2D Matrix
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        for(int i =0; i< row; i++){
            if(matrix[i][0] == target || matrix[i][col-1] == target)
                return true;
            else if(matrix[i][0] < target && target < matrix[i][col-1]){
                //int[] arr= 
                int idx = doBinarySearch(matrix, i, col, target);
                if(idx != -1)
                    return true;
                else
                    return false;
            }
        }
        
        return false;
        
    }
    
    private int doBinarySearch(int[][] matrix, int row, int col, int target){
        int low = 0;
        int high = col-1;
        while(low <= high){
            int mid = (low+high)/2;
            
            if(matrix[row][mid] == target){
                return mid;
            }else if(matrix[row][mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        
        return -1;
    }
}