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
    public class LevelTreeNode {
		int level;
		TreeNode node;
		
		public LevelTreeNode(int level, TreeNode node) {
			this.level = level;
			this.node = node;
		}
	}

    public void addNode (Deque<LevelTreeNode> deque, TreeNode node, int level) {
		if (node.left != null) deque.addLast(new LevelTreeNode(level, node.left));
		if (node.right != null) deque.addLast(new LevelTreeNode(level, node.right));
	}

    public int maxLevelSum(TreeNode root) {
    	Deque<LevelTreeNode> deque = new ArrayDeque<>();
    	addNode(deque, root, 2);
    	
    	int maxSum = root.val;
    	int sum = 0;
    	int currentLevel = 2;
    	int maxSumLevel = 1;
    	while (!deque.isEmpty()) {
    		LevelTreeNode levelTreeNode = deque.pollFirst();
    		int level = levelTreeNode.level;
    		TreeNode node = levelTreeNode.node;
    		
    		if (currentLevel != level) {
    			if (maxSum < sum) {
                    maxSumLevel = currentLevel;
                    maxSum = sum;
                }
    			currentLevel = level;
    			sum = 0;
    		}
    		sum += node.val;
        	addNode(deque, node, level+1);
    	}
    	
        return (maxSum < sum) ? currentLevel : maxSumLevel;
    }
}