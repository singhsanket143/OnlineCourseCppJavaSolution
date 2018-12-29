package Trees;

import java.util.*;

public class IsBalanced_BT {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		IsBalanced_BT m = new IsBalanced_BT();
		BinaryTree bt1 = m.new BinaryTree();
		bt1.isBalanced();
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree() {
			this.root = this.takeInput(null, false);
		}

		public Node takeInput(Node parent, boolean ilc) {

			int cdata = scn.nextInt();
			Node child = new Node();
			child.data = cdata;
			this.size++;

			// left
			boolean hlc = scn.nextBoolean();

			if (hlc) {
				child.left = this.takeInput(child, true);
			}

			// right
			boolean hrc = scn.nextBoolean();

			if (hrc) {
				child.right = this.takeInput(child, false);
			}

			// return
			return child;
		}

		public void isBalanced() {
			if (isBalanced(this.root)) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}

		}

		private boolean isBalanced(Node node) {
			int lh; /* for height of left subtree */

			int rh; /* for height of right subtree */

			/* If tree is empty then return true */
			if (node == null)
				return true;

			/* Get the height of left and right sub trees */
			lh = height(node.left);
			rh = height(node.right);

			if (Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right))
				return true;

			/* If we reach here then tree is not height-balanced */
			return false;
		}

		// height of tree
		public int height(Node node) {
			/* base case tree is empty */
			if (node == null)
				return 0;

			/*
			 * If tree is not empty then height = 1 + max of left height and right heights
			 */
			return 1 + Math.max(height(node.left), height(node.right));
		}

	}
}
