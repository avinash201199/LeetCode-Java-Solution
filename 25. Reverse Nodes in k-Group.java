class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;
	
        ListNode prev = null, next = null, cur = head;
        int count = 0;
        /* Reverse upto k in place */
		while (count < k && cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }
        
		/* If more to be reversed */
        if (cur != null)
            head.next = reverseKGroup(cur, k);
        else if (count < k)
            return reverseKGroup(prev, count); /* Additional nodes must not be reversed */
    
        return prev;
    }
}
