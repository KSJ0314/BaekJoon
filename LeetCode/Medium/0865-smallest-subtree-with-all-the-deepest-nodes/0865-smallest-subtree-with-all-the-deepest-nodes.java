/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public class TreeNodeWithLevel {
		TreeNode tree;
		int level;
		
		public TreeNodeWithLevel(TreeNode tree, int level) {
			this.tree = tree;
			this.level = level;
		}
	}
	
	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		HashMap<Integer, TreeNode> treeMap = new HashMap<>();
		
		Deque<TreeNodeWithLevel> deque = new ArrayDeque<>();
		Deque<TreeNode> deque2 = new ArrayDeque<>();
		deque.addLast(new TreeNodeWithLevel(root, 0));
		int maxLevel = 0;
		while (!deque.isEmpty()) {
			TreeNodeWithLevel twl = deque.pollFirst();
			if (maxLevel != twl.level) deque2.clear();
			maxLevel = twl.level;
			deque2.addLast(twl.tree);
			
			if(twl.tree.left != null) {
				deque.addLast(new TreeNodeWithLevel(twl.tree.left, twl.level+1));
				treeMap.put(twl.tree.left.val, twl.tree);
			}
			if(twl.tree.right != null) {
				deque.addLast(new TreeNodeWithLevel(twl.tree.right, twl.level+1));
				treeMap.put(twl.tree.right.val, twl.tree);
			}
		}
		
		boolean[] isVisited = new boolean[501];
		while (deque2.size() > 1) {
			TreeNode tree = deque2.pollFirst();
			if (isVisited[treeMap.get(tree.val).val]) continue;
			isVisited[treeMap.get(tree.val).val] = true;
			
			deque2.addLast(treeMap.get(tree.val));
		}
		
		return deque2.pollFirst();
    }
}