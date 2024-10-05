package LeetCode;

import contest.ListNode;

public class ListRemoveNthFromEnd {

    public static void main(String[] args) {
        ListRemoveNthFromEnd obj = new ListRemoveNthFromEnd();
        final ListNode listNode = obj.removeNthFromEnd(ListNode.arrayToListNode(new int[]{1, 2, 3, 4, 5}), 5);
        System.out.println("res: " + listNode);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }
        if(curr == null) return head.next;
        ListNode start = head;
        while (curr.next != null) {
            curr = curr.next;
            start = start.next;
        }
        start.next = start.next.next;
        return head;
    } // https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

}
