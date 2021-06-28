/* Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * 
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 * 
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 * 
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 * 
 * Constraints:
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 * 使用哈希表，将每一个节点的引用都存起来，如果哈希表中存在了某一个节点的引用，说明此链表是循环的。
 * https://mp.weixin.qq.com/s?__biz=MzAwMjc2MDczOQ==&mid=2649429746&idx=1&sn=360f865ddc64390ca5fed35cb5773ccb&chksm=82da3fbeb5adb6a82f72f34801919e9bd490492dc1751f93696a01cecf6af8d0428069e9b3b5&scene=21#wechat_redirect
 * https://www.bilibili.com/video/BV1cQ4y1P7Vd
 * 
 * https://www.jiuzhang.com/problem/linked-list-cycle/
 */
package com.JavaBasicQuestions;

import java.util.HashSet;
import java.util.Set;

public class Easy141LinkedListCycle {
	public static void main(String[] args) {
		
		ListNode head = new ListNode(3);
		ListNode L1 = new ListNode(2);
		ListNode L2 = new ListNode(0);
		ListNode L3 = new ListNode(4);
		
		head.next = L1;
		L1.next = L2;
		L2.next = L3;
		L3.next = L1;
		
		
		/*
		ListNode head = new ListNode(1);
		ListNode L1 = new ListNode(2);
		head.next = L1;
		*/
		
		Easy141LinkedListCycle llc = new Easy141LinkedListCycle();
		System.out.println(llc.hasCycle(head));
	}
	
	//Two Pointers: fast  Time Complexity: O(N) Space Complexity: O(1)
	//快慢指针的经典题。 快指针每次走两步，慢指针一次走一步。 
	//在慢指针进入环之后，快慢指针之间的距离每次缩小1，所以最终能相遇。
	 public boolean hasCycle(ListNode head) {
	    if (head == null || head.next == null) { 
	        return false;
	    }
	    ListNode slow = head;
	    ListNode fast = head;
	    while (slow != null && fast != null && fast.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	        if (slow == fast) {
	            return true;
	        }
	    }
	    return false;
	}
}
	
/*
	//hashset:slow
	//Time Complexity: O(N) Space Complexity: O(N)
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) { 
	        return false;
	    }
		
	    Set<ListNode> visited = new HashSet<ListNode>();//hashset, store every node reference
	    while (head != null) {
	        if (visited.contains(head)) {//if hashset has any node reference
	            return true; //has cycle
	        } else {//does not have any node reference
	        	visited.add(head); //add node
	        }
	        head = head.next;
	    }
	    return false;//head is null
	}
}

 */
