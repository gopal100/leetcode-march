/*
https://leetcode.com/problems/copy-list-with-random-pointer/submissions/
138. Copy List with Random Pointer

*/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node current =head;
        Map<Node, Node> map = new HashMap<>();
        Node newHead = null;
        Node nd = null;
        
        while(current!= null){
            Node copy = new Node(current.val);
            map.put(current, copy);
            current = current.next;
        }
        current = head;
        for(Map.Entry<Node, Node> data : map.entrySet()){
            Node newNode = data.getValue();
            Node oldNode = data.getKey();
            newNode.next = map.get(oldNode.next);
            newNode.random = map.get(oldNode.random);
        }
        
        return map.get(head);
    }
}