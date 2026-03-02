class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0), after = new ListNode(0);
        ListNode b = before, a = after;
        while (head != null) {
            if (head.val < x) {
                b.next = head;
                b = b.next;
            } else {
                a.next = head;
                a = a.next;
            }
            head = head.next;
        }
        a.next = null;
        b.next = after.next;
        return before.next;
    }
}