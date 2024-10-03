package LeetCode;

import contest.ListNode;

//https://leetcode.com/problems/merge-two-sorted-lists/description/
public class MergeTwoSortedList {

    public static void main(String[] args) {
        MergeTwoSortedList obj = new MergeTwoSortedList();
        final ListNode listNode = obj.mergeTwoListsV2(
                ListNode.arrayToListNode(new int[]{1,2,4}),
                ListNode.arrayToListNode(new int[]{1,3,4}));
        ListNode.printList(listNode);
    }

    public ListNode mergeTwoListsV2(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 != null) curr.next = list1;
        if (list2 != null) curr.next = list2;

        return head.next;

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode res;

        if (list1.val < list2.val) {
            res = list1;
            System.out.println("added " + res.val);
            list1 = list1.next;
        } else {
            res = list2;
            System.out.println("added " + res.val);
            list2 = list2.next;
        }
        ListNode temp = res;

        while (list1 != null && list2 != null ) {
            System.out.println("comparing list1 " + list1.val + " list2 " + list2.val);
            if(list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
                System.out.println("list 1 is now " + list1);
            } else {
                temp.next = list2;
                list2 = list2.next;
                System.out.println("list 2 is now " + list1);
            }
            temp = temp.next;
            System.out.println("added temp " + temp.val);
            if (temp.next != null) {
                System.out.println("temp next is " + temp.next.val);
            }

        }
        if (list1 != null) temp.next = list1;
        if (list2 != null) temp.next = list2;

        return res;
    }
}
