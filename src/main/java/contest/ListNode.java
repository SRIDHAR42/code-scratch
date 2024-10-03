package contest;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode arrayToListNode(int[] arr) {
        // Handle edge case for empty array
        if (arr == null || arr.length == 0) {
            return null;
        }

        // Create the head node
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        // Iterate through the array and create subsequent nodes
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head; // Return the head of the linked list
    }

    // Function to print the ListNode for testing
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    @Override
    public String toString() {
        String next = (this.next != null)? this.next.toString():" null";
        return this.val + " -> " + next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = arrayToListNode(arr);
        printList(head);  // Expected output: 1 -> 2 -> 3 -> 4 -> 5 -> null
    }
}
