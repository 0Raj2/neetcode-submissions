/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<ListNode> headAList = new ArrayList();
        List<ListNode> headBList = new ArrayList();

        ListNode tempA = headA;

        while (tempA != null) {
            headAList.add(tempA);
            tempA = tempA.next;
        }

        ListNode tempB = headB;

        while (tempB != null) {
            headBList.add(tempB);
            tempB = tempB.next;
        }

        int endA = headAList.size() - 1;
        int endB = headBList.size() - 1;

        ListNode prevNode = new ListNode(0);
        while (endA >= 0 && endB >= 0) {
            if (headAList.get(endA).val != headBList.get(endB).val) {
                return prevNode;
            }else if(headAList.get(endA).val == headBList.get(endB).val){
                prevNode = headAList.get(endA);
                endA--;
                endB--;
            }
            
        }

        return prevNode;
    }
}