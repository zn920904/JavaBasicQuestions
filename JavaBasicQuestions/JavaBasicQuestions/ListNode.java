package com.JavaBasicQuestions;
/*
public class ListNode {
	int data;
    ListNode next;
    ListNode(int data){
        this.data = data;
    }

}
*/

public class ListNode {
	int val;
	ListNode next;
	ListNode() {
		
	}
	ListNode(int val) { 
		 this.val = val; 
		 }
	 ListNode(int val, ListNode next) { 
		 this.val = val; 
		 this.next = next; 
		 }
	 
	@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
}
