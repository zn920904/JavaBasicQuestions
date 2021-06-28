/* Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * Follow up: Could you do this in one pass?
 * 
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * 
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 * 
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 * 
 * Constraints:
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz

 */
package com.JavaBasicQuestions;

public class Medium19RemoveNthNodeFromEndofList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode L1 = new ListNode(2);
		ListNode L2 = new ListNode(3);
		ListNode L3 = new ListNode(4);
		ListNode L4 = new ListNode(5);
		
		head.next = L1;
		L1.next = L2;
		L2.next = L3;
		L3.next = L4;
		
		int n = 2;
		
		Medium19RemoveNthNodeFromEndofList llc = new Medium19RemoveNthNodeFromEndofList();
		System.out.println(llc.removeNthFromEnd(head,n));
	}
	//one pass
	//Time complexity : O(L); Space complexity : O(1). We only used constant extra space.
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null) {
            return null;
        }
        if(head.next == null && n == 1){
            return null;
        }
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode fast = dummy;
	    ListNode slow = dummy;
	    // Advances fast pointer so that the gap between first and second is n nodes apart
	    for (int i = 1; i <= n + 1; i++) {
	    	fast = fast.next; //let fast walks n steps
	    }
	    // Move fast to the end, maintaining the gap
	    while (fast != null) {
	    	fast = fast.next;
	    	slow = slow.next;
	    }
	    slow.next = slow.next.next;
	    return dummy.next;
	}
	
	
/*
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);//image fake node: dummy
        dummy.next = head;
        ListNode slow = dummy;// using two pointers: slow, fast
        ListNode fast = dummy;
        
        if(head == null) {
            return null;
        }
        if(head.next == null && n==1){
            return null;
        }
        //fast moves n steps from dummy
        //then, fast and slow move at the same 
        while(n != 0){
            n--;
            fast = fast.next;
        }
        //when fast.next is null, this time slow.next is needed to be deleted
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
*/
}
