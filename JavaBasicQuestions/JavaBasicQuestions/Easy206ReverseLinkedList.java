/* Reverse a singly linked list.
 * 
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * 
 * Follow up:
 * A linked list can be reversed either iteratively or recursively.
 * Could you implement both?
 * 
 */
package com.JavaBasicQuestions;

public class Easy206ReverseLinkedList {
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
		
		Easy206ReverseLinkedList llc = new Easy206ReverseLinkedList();
		System.out.println(llc.reverseList(head));
	}
	
	//recursive: time: O(n)，space: O(n)。
	//find last node location,then reverse pointer's direction
	//original: n(k)-->n(k+1); now: n(k+1)-->n(k), n(k).next.next = n(k)
	public ListNode reverseList(ListNode head) {
	    if (head == null || head.next == null) {
	        return head;
	    }
	    ListNode result = reverseList(head.next);
	    head.next.next = head; 
	    head.next = null;//avoid dead cycle
	    return result;
	}
}


/* Iterative: time: O(n)，space: O(1)。
 * public ListNode reverseList(ListNode head) { //1 -> 2 -> 3 -> null
	 	if (head == null || head.next == null) {
		    return head;
		}
        ListNode dummy = new ListNode(0);
        dummy.next = head; // dummy -> 1 -> 2 -> 3 -> null, head is 1 now
        while(head != null && head.next != null){
        ListNode next = head.next;
        ListNode temp = dummy.next;
        head.next = head.next.next;
        dummy.next = next;
        next.next = temp;
    }
       return dummy.next;
  }  
*/