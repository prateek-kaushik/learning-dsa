package com.prateek.learning.dsa;

public class BinarySearchTree {
	class Node {
		int key;
		Node left, right;

		public Node(int key) {
			this.key = key;
		}
	}

	Node root;

	public static void main(String args[]) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);
		bst.insert(30);
		bst.insert(70);
		bst.insert(60);
		bst.insert(10);
		bst.insert(90);
		bst.insert(40);
		bst.insert(80);

		bst.inOrder(bst.root);

		System.out.println();
		System.out.println("Deleting...70 ");
		bst.delete(70);
		System.out.println();
		System.out.println("After deletion ");
		bst.inOrder(bst.root);

		System.out.println();
		System.out.println("Searching...80 ");
		System.out.println("Found=" + bst.search(80));
	}

	public void insert(int key) {
		if (root == null) {
			root = new Node(key);
			return;
		}

		Node parent = null;
		Node current = root;
		while (current != null) {
			parent = current;
			if (current.key >= key) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		if (parent.key >= key) {
			parent.left = new Node(key);
		} else {
			parent.right = new Node(key);
		}
	}

	public void delete(int key) {
		delete(root, key);
	}

	private Node delete(Node node, int key) {
		if (node == null) {
			System.out.println("delete::node=null");
			return null;
		}
		System.out.println("delete::node=" + node.key);
		if (node.key > key) {
			node.left = delete(node.left, key);
		} else if (node.key < key) {
			node.right = delete(node.right, key);
		} else {
			if (node.left == null && node.right == null) {
				node = null;
			} else if (node.left == null) {
				node = node.right;
			} else if (node.right == null) {
				node = node.left;
			} else {
				Node temp = minNode(node.right);
				System.out.println("temp=" + temp.key);
				node.key = temp.key;
				node.right = delete(node.right, temp.key);
			}
		}
		return node;
	}

	private Node minNode(Node node) {
		if (node.left != null) {
			System.out.println("minNode1::node=" + node.key);
			return minNode(node.left);
		}
		if (node != null) {
			System.out.println("minNode2::node=" + node.key);
		}

		return node;
	}

	public Node search(int key) {
		Node current = root;

		while (current != null) {
			if (current.key == key) {
				return current;
			} else if (current.key >= key) {
				current = current.left;
			} else {
				current = current.right;
			}
		}

		return null;
	}

	public void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.key + " ");
		inOrder(node.right);
	}
}
