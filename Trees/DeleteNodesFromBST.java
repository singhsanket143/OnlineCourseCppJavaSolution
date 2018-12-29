package Trees;

import java.util.*;

public class DeleteNodesFromBST {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		DeleteNodesFromBST m = new DeleteNodesFromBST();
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			BST bt = m.new BST(n);
			bt.deleteKey();
			bt.preorder();
		}
	}

	private class BST {
		private class Node {
			int data;
			Node left;
			Node right;

			Node(int data, Node left, Node right) {
				this.data = data;
				this.left = left;
				this.right = right;
			}
		}

		private Node root;
		private int size;

		public BST(int n) {
			this.root = this.construct(n);
		}

		// inserting in the BST
		private Node insertInBst(Node root, int d) {
			if (root == null) {
				return new Node(d, null, null);
			}
			// Rec Case
			if (d < root.data) {
				root.left = insertInBst(root.left, d);
			} else {
				root.right = insertInBst(root.right, d);
			}
			return root;
		}

		// constructing BST
		private Node construct(int n) {

			Node root = null;
			int i = 0;
			while (i < n) {
				int d = scn.nextInt();
				root = insertInBst(root, d);
				i++;
			}
			return root;
		}

		// This method mainly calls deleteRec()
		void deleteKey() {
			int num = scn.nextInt();
			while (num > 0) {
				int key = scn.nextInt();
				this.root = deleteRec(root, key);
				num--;
			}

		}

		/* A recursive function to insert a new key in BST */
		Node deleteRec(Node root, int key) {
			/* Base Case: If the tree is empty */
			if (root == null)
				return root;

			/* Otherwise, recur down the tree */
			if (key < root.data)
				root.left = deleteRec(root.left, key);
			else if (key > root.data)
				root.right = deleteRec(root.right, key);

			// if key is same as root's key, then This is the node
			// to be deleted
			else {
				// node with only one child or no child
				if (root.left == null)
					return root.right;
				else if (root.right == null)
					return root.left;

				// node with two children: Get the inorder successor (smallest
				// in the right subtree)
				root.data = minValue(root.right);

				// Delete the inorder successor
				root.right = deleteRec(root.right, root.data);
			}

			return root;
		}

		int minValue(Node root) {
			int minv = root.data;
			while (root.left != null) {
				minv = root.left.data;
				root = root.left;
			}
			return minv;
		}

		public void preorder() {
			this.preorder(this.root);
			System.out.println();

		}

		private void preorder(Node node) {
			if (node == null) {
				return;
			}
			System.out.print(node.data + " ");
			preorder(node.left);
			preorder(node.right);
		}

	}

}
