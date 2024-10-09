package LeetCode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class LinkedListSimple {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        if (head.next == head) return true;

        ListNode slow = head, fast = head.next.next;

        while (slow != null && fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = (fast.next != null)? fast.next.next: null;

        }
        return false;
    } // https://leetcode.com/problems/linked-list-cycle/

    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null, temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }



}
