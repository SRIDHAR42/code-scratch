package contest;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkList {

    public static ListNode arrayToLinkList(ArrayList<Integer> a) {
        ListNode head = new ListNode(a.get(0));
        ListNode cur = head;
        for (int i = 1; i < a.size(); i++) {
            cur.next = new ListNode(a.get(i));
            cur = cur.next;
        }
        return head;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        //cur is null last node is prev
        return prev;
    }

    public static boolean isPalindromeList(ListNode head) {
        int len = 0;
        boolean res = true;

        //check len
        ListNode cur = head;
        while(cur != null) {
            len++;
            cur = cur.next;
        }

        int mid = len/2 +1;
        cur = head;
        ListNode prev = null;
        for (int i = 1; i < mid; i++) {
            prev = cur;
            cur = cur.next;
        }

        cur = reverseList(cur);

        //match head and cur from pos ;
        ListNode start = head;
        res = chekEqual(start, cur, mid-1);
        prev.next = reverseList(cur);
        return res;
    }

    private static boolean chekEqual(ListNode start, ListNode cur, int len) {
        boolean res = true;
        for (int i = 0; i< len; i++) {
            if (!equalNode(start, cur)) res = false;
            start = start.next;
            cur = cur.next;
        }
        return res;
    }

    private static boolean equalNode(ListNode start, ListNode cur) {
        return (start != null &&
                cur != null &&
                start.val == cur.val);
    }

    public static void printList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        final ListNode listNode;
        listNode = LinkList.arrayToLinkList(new ArrayList<>(Arrays.asList(1, 2, 2, 1)));
        ListNode rev = LinkList.reverseList(listNode);
        boolean isPalindrome = isPalindromeList(rev);
        System.out.println(isPalindrome);
    }
}
