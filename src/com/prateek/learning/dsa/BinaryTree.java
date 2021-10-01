package com.prateek.learning.dsa;

public class BinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			String str = "node=" + val + "(" + hashCode() + ")";
			if (left != null) {
				str = str + ", node.left=" + left.val + "(" + this.left.hashCode() + ")";
			} else {
				str = str + ", node.left=null";
			}
			if (right != null) {
				str = str + ", node.right=" + right.val + "(" + this.right.hashCode() + ")";
			} else {
				str = str + ", node.right=null";
			}
			return str;
		}
	}

	public static void main(String args[]) {
		int[] nums = { 3, 2, 1, 6, 0, 5 };

		BinaryTree btree = new BinaryTree();
		TreeNode root = btree.findMax(nums, 0, nums.length - 1);
	}

	public TreeNode findMax(int[] nums, int start, int end) {
		TreeNode root;
		if (start > end) {
			return null;
		}
		int max = nums[start];
		int index = start;
		for (int i = start + 1; i <= end; i++) {
			if (max < nums[i]) {
				max = nums[i];
				index = i;
			}
		}
		root = new TreeNode(nums[index]);
		root.left = findMax(nums, start, index - 1);
		root.right = findMax(nums, index + 1, end);
		System.out.println(root.toString());
		return root;
	}
}