/*
https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
81. Search in Rotated Sorted Array II

*/

class Solution {
    public boolean search(int[] nums, int target) {
       /* int pivot = findPivot(nums, 0, nums.length-1);
        int idx = 0;
        System.out.println(pivot);
        if(pivot == -1)
            idx = binarySearch(nums, 0, nums.length-1, target);
        
        else{
            
            if(nums[pivot] == target){
                System.out.println("target 0:");
                idx = pivot;            
            }
            else if(nums[0] <= target){
                System.out.println("target 1:");
                idx = binarySearch(nums, 0, pivot-1, target);
            }else{
                System.out.println("target 2:");
                idx = binarySearch(nums, pivot+1, nums.length-1, target);
            }
            
            System.out.println("id :"+idx);
                
        }
        */
        
        int idx = 0;
        idx =  search(nums, 0, nums.length-1, target);
        
        if(idx != -1)
            return true;
        else
            return false;
    }
    
    static int search(int arr[], int l, int h, int key)
    {
        if (l > h)
            return -1;
     
        int mid = l + (h - l) / 2;
        if (arr[mid] == key)
            return mid;
     
        // The tricky case, just update left and right
        if ((arr[l] == arr[mid])
            && (arr[h] == arr[mid]))
        {
            l++;
            h--;
              return search(arr,l,h,key);
        }
     
        // If arr[l...mid] is sorted
        else if (arr[l] <= arr[mid])
        {
     
            // As this subarray is sorted, we can quickly
            // check if key lies in any of the halves
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid - 1, key);
     
            // If key does not lie in the first half
            // subarray then divide the other half
            // into two subarrays such that we can
            // quickly check if key lies in the other half
            else
              return search(arr, mid + 1, h, key);
        }
     
        // If arr[l..mid] first subarray is not sorted
        // then arr[mid... h] must be sorted subarray
           else  if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid + 1, h, key);
     
        return search(arr, l, mid - 1, key);
    }
    
    private int findPivot(int[] nums, int low, int high){
        if(high < low)
            return -1;
        if(high == low)
            return low;
        
        int mid = (low+high)/2;
        
        if(mid < high && nums[mid]> nums[mid+1])
            return mid;
        else if(mid > low && nums[mid] < nums[mid-1])
            return mid-1;
        else if(nums[low] >= nums[mid])
            return findPivot(nums, low, mid-1);
        else
            return findPivot(nums, mid+1, high);
    }
    
    private int binarySearch(int[] nums, int low, int high, int target){
        int mid = 0;
        while(low <= high){
            mid = (low+high)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target){
                low = mid+1;
            }
            else
                high =mid-1;
        }
        
        return -1;
    }
}