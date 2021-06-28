/* Input:  1->11->36->8,  index = 2
 * Output: 36
 * The node at index 2 is 36
 */
package com.JavaBasicQuestions;

public class FindTheNthNode {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode L1 = new ListNode(11);
		ListNode L2 = new ListNode(36);
		ListNode L3 = new ListNode(8);
		
		head.next = L1;
		L1.next = L2;
		L2.next = L3;
		
		int index = 2;
		
		FindTheNthNode llc = new FindTheNthNode();
		System.out.println(llc.FindNthNode(head, index));
	}
	
	ListNode head;
	public int FindNthNode(ListNode head, int index) {
		if(head == null) {
			return -1;
		}
		
		ListNode current = head;
		int count = 0;
		while(current != null) {
			if(count == index) {
				return current.val;
			}
			count++;
			current = current.next;
		}
		return -1;
	}
}
