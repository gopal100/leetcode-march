/*
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/submissions/

Remove Duplicates from Sorted List II
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode prev = null;
        ListNode current = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        prev = dummy;
        
        while(current != null){
            
            while(current.next!= null && current.val == current.next.val){
                current = current.next;
            }
            
            if(prev.next == current)
                prev = prev.next;
            else
                prev.next = current.next;
            
            current = current.next;
        }
        
        return dummy.next;
    }
}