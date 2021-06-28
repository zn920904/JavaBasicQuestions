/* Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. 
 * Note that pos is not passed as a parameter.
 * Notice that you should not modify the linked list.
 * 
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * 
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * 
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * 
 * Constraints:
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 * 
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 * https://www.jiuzhang.com/problem/linked-list-cycle-ii/
 * 
 */
package com.JavaBasicQuestions;

import java.util.HashSet;
import java.util.Set;

public class Medium142LinkedListCycleII {
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		ListNode L1 = new ListNode(2);
		ListNode L2 = new ListNode(0);
		ListNode L3 = new ListNode(4);
		head.next = L1;
		L1.next = L2;
		L2.next = L3;
		L3.next = L1;
		Medium142LinkedListCycleII llc = new Medium142LinkedListCycleII();
		
		ListNode startCycleNode = llc.detectCycle(head);
		if(startCycleNode != null) {
			System.out.println("Start node value = " + startCycleNode.val);
		}else {
			System.out.println("No cycle!");
		}
		
	}
	
	//Two Pointers: fast  Time Complexity: O(N) Space Complexity: O(1)
	public ListNode detectCycle(ListNode head) {
	    if (head == null || head.next == null) {
	        return null;   // no circle
	    }
	    ListNode slow = head;
	    ListNode fast = head;
	    while (slow != null && fast != null && fast.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	        if (fast == slow) {  // circle detected
	            while (head != fast) {
	                fast = fast.next;
	                head = head.next;
	            }
	            return head;
	        }
	    }
	    return null; // no circle
	}
}
/*
	//HashSet
	public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodesVisited = new HashSet<ListNode>();
        while (head != null) {
            if (nodesVisited.contains(head)) {
                return head;
            }else {
            	nodesVisited.add(head);
            }
            head = head.next;
        }
        return null;
    }

}
*/
