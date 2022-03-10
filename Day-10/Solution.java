/*
https://leetcode.com/problems/add-two-numbers/

Add Two Numbers
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode finalList = null;
        
        int l1size = 0;
        int l2size = 0;
        
        int size = l1size>l2size ? l1size : l2size;
        int carry = 0;
        ListNode head = null;
        while(l1 !=null || l2 !=null){
            
            int l1val = 0;
            int l2val = 0;
            if(l1== null){
                l1val = 0;
            }else 
                l1val = l1.val;
            
            if(l2== null){
                l2val = 0;
            }else 
                l2val = l2.val;
            
            int value = (l1val + l2val) + carry;
            if(value >= 10){
                value = value %10;
                carry = 1;
            }else
                carry = 0;
            
            ListNode node = new ListNode();
            node.val = value;
            node.next = null;
            if(finalList == null){
                finalList = node;
                head = finalList;
            }else{
                finalList.next = node;
                finalList = finalList.next;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        
        if(carry > 0){
            ListNode node = new ListNode();
            node.val = carry;
            node.next = null;
            finalList.next = node;
        }
        return head;
    }
    
    
}