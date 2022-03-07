/*
https://leetcode.com/problems/merge-two-sorted-lists/

Merge Two Sorted Lists
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            
        ListNode head = null;
        ListNode current = null;
        while(list1 != null && list2 != null){
            ListNode temp1 = null;
            ListNode temp2 = null;
            if(list1.val < list2.val){
                temp1 = list1;
                list1 = list1.next;
            }else if(list1.val > list2.val){
                temp1 = list2;
                list2 = list2.next;
            }else{
                temp1 = list1;
                temp2 = list2;
                list1 = list1.next;
                list2 = list2.next;
            }
            if(head == null){
                current = temp1;
                head = current;
            }
            else{
                current.next = temp1;
                current = current.next;
            }
            if(temp2 != null){
                current.next = temp2;
                current = current.next;
            }
                
        }
        
        while(list1!= null){
            if(head == null){
                current = list1;
                head = current;
            }else{
                current.next = list1;
                current = current.next;
            }
            list1 = list1.next;
            
        }
        while(list2!= null){
            if(head == null){
                current = list2;
                head = current;
            }else{
                current.next = list2;
                current = current.next;
            }
            list2 = list2.next;
        }
        
        
        
        return head;
    }
}