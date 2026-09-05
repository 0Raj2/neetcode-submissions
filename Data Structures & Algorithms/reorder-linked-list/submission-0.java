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
    public void reorderList(ListNode head) {
        ListNode curr = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode helpRev = reversNode(slow);
        ListNode temp1 = null;
        ListNode temp2 = null;

        boolean flag = true;

        while (helpRev.next != null || curr.next != null) {
            if (flag) {
                flag = false;
                temp1 = curr.next;
                curr.next = helpRev;
                curr = temp1;

            } else {
                flag = true;
                temp2 = helpRev.next;
                helpRev.next = curr;
                helpRev = temp2;
            }
        }

    }

    public ListNode reversNode(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = null;

        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
