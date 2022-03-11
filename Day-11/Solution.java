/*
https://leetcode.com/problems/rotate-list/submissions/
61. Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        Map<ListNode, ListNode> map = new HashMap<>();
        ListNode current = head;
        ListNode prev = null;
        ListNode temp = head;
        
        int len = 0;
        while(temp != null){
            temp = temp.next;
            len++;
        }
        if(len == 0 || len ==1 || k ==0)
            return head;
        
        if(len > k){
            int range = len-k;
            
            ListNode cur = head;
            ListNode next = cur;
            while(range-- > 0){
                cur = next;
                next = cur.next;
            }
            cur.next = null;
            ListNode oldhead = head;
            head = next;
            
            while(next != null && next.next != null){
                next = next.next;
            }
            next.next = oldhead;
        }else{
            int mod = k %len;
            mod = len-mod;
            if(mod == 0 || mod == len)
                return head;
            ListNode cur = head;
            ListNode next = cur;
            while(mod-- > 0){
                cur = next;
                next = cur.next;
            }
            cur.next = null;
            ListNode oldhead = head;
            head = next;
            
            while(next.next != null){
                next = next.next;
            }
            next.next = oldhead;
        }
        return head;
    }
}