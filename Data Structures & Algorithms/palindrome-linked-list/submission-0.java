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
    public boolean isPalindrome(ListNode head) {
         ListNode reversHead = reverseList(head);

        while(head != null && reversHead != null){
            System.out.println(head.val);
             System.out.println(reversHead.val);
            if(head.val != reversHead.val){
                return false;
            }
            head = head.next;
            reversHead = reversHead.next;
        }

        return true;

    }

    public ListNode reverseList(ListNode head) {

    if (head == null || head.next == null) {
      return head;
    }

    ListNode curr = head;
    ListNode prev = null;
    ListNode temp = null;

    while (curr.next != null) {
      temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
    }

    curr.next = prev;

    return curr;
        
    }
}