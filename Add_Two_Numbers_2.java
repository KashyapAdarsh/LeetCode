/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head;
        ListNode node = new ListNode(0);
        head = node;
        int carry = 0;
        
        while(l1 != null && l2 != null){
            int temp = l1.val + l2.val;
            if(temp + carry <= 9){
                node.next = new ListNode(temp + carry);
                carry = 0;
            }
            else{
                node.next = new ListNode((temp + carry) % 10);
                carry = (temp + carry) / 10;
            }
            l1 = l1.next;
            l2 = l2.next;
            node = node.next;
        }
        
        if(l1 == null){
            while(l2 != null){
                if(l2.val + carry <= 9){
                    node.next = new ListNode(l2.val + carry);
                    carry = 0;
                }
                else{
                    node.next = new ListNode((l2.val + carry) % 10);
                    carry = (l2.val  + carry) / 10;
                }
                l2 = l2.next;
                node = node.next;
            }
        }else{
            while(l1 != null){
                if(l1.val + carry <= 9){
                    node.next = new ListNode(l1.val + carry);
                    carry = 0;
                }
                else{
                    node.next = new ListNode((l1.val + carry) % 10);
                    carry = (l1.val  + carry) / 10;
                }
                l1 = l1.next;
                node = node.next;
            }
        }
        
        if(carry != 0)
            node.next = new ListNode(carry);
        
        return head.next;
    }
}