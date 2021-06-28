/* Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 * 
 */
package com.JavaBasicQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Medium102BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
		TreeNode root =  new TreeNode(3);  
		root.left = new TreeNode(9);  
		root.right = new TreeNode(20);
		root.left.left = new TreeNode();
		root.left.right = new TreeNode();
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		Medium102BinaryTreeLevelOrderTraversal ot = new Medium102BinaryTreeLevelOrderTraversal();
	    System.out.println(ot.levelOrder(root));
	}
	//BFS
	//Time Complexity: O(N) Space Complexity: O(N)
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>();//create list to store result
		//List<List<Integer>> result = new ArrayList<>();
		if (root == null) {//corner case
			return result;
		}
			
		Queue<TreeNode> queue = new LinkedList<>();//BFS's feature
		queue.add(root);//first, add root in the queue
		
		while(!queue.isEmpty()) {//check queue is empty or not
			int size = queue.size();//declare queue's size
			List<Integer> levelResult = new LinkedList<>();//create list to store level result
			for(int i = 0; i < size; i++) {//iterate each element in queue
				//while(size > 0){
				TreeNode current = queue.poll();//get current 
				levelResult.add(current.val);//add current's val to level result
				//size--;
				if (current.left != null)//check current's left is null or not
					queue.add(current.left);//not null, add current's left to queue
				if (current.right != null)//the same as above
					queue.add(current.right);
			}
			result.add(levelResult);//inner loop end, add level result to result
		}
		return result; //whole loop end, return result
	}
}



/* //  DFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (root == null) {
            return results;
        }
        
        int maxLevel = 0;
        while (true) {
            List<Integer> level = new ArrayList<Integer>();
            dfs(root, level, 0, maxLevel);
            if (level.size() == 0) {
                break;
            }
            
            results.add(level);
            maxLevel++;
        }
        return results;
    }
    
    private void dfs(TreeNode root, List<Integer> level, int curtLevel, int maxLevel) {
        if (root == null || curtLevel > maxLevel) {
            return;
        }
        
        if (curtLevel == maxLevel) {
            level.add(root.val);
            return;
        }
        dfs(root.left, level, curtLevel + 1, maxLevel);
        dfs(root.right, level, curtLevel + 1, maxLevel);
    }
}
 * 
 */
