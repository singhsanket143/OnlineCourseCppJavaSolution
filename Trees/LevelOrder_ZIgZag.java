package Trees;

import java.util.*;

public class LevelOrder_ZIgZag {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		LevelOrder_ZIgZag m = new LevelOrder_ZIgZag();
		BinaryTree bt1 = m.new BinaryTree();
		bt1.printZigZagTraversal();
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

		public void printZigZagTraversal() {

			// if null then return
			if (this.root == null) {
				return;
			}

			// declare two stacks
			Stack<Node> currentLevel = new Stack<>();
			Stack<Node> nextLevel = new Stack<>();

			// push the root
			currentLevel.push(this.root);
			boolean leftToRight = true;

			// check if stack is empty
			while (!currentLevel.isEmpty()) {

				// pop out of stack
				Node node = currentLevel.pop();

				// print the data in it
				System.out.print(node.data + " ");

				// store data according to current
				// order.
				if (leftToRight) {
					if (node.left != null) {
						nextLevel.push(node.left);
					}

					if (node.right != null) {
						nextLevel.push(node.right);
					}
				} else {
					if (node.right != null) {
						nextLevel.push(node.right);
					}

					if (node.left != null) {
						nextLevel.push(node.left);
					}
				}

				if (currentLevel.isEmpty()) {
					leftToRight = !leftToRight;
					Stack<Node> temp = currentLevel;
					currentLevel = nextLevel;
					nextLevel = temp;
				}
			}
		}

	}
}
