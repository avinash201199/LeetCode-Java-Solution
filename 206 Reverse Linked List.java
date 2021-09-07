class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode nextNode = head.next;
        ListNode revHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return revHead;
    }
}
