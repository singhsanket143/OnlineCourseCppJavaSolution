package Trees;

import java.util.Scanner;

public class CreateTreeUsingPreorderAndInorder {
	static Scanner scn = new Scanner(System.in);

	public static void main(String args[]) {
		int size = scn.nextInt();
		int[] preorder = new int[50];
		int[] inorder = new int[50];

		for (int i = 0; i < size; i++) {
			preorder[i] = scn.nextInt();
		}

		size = scn.nextInt();

		for (int i = 0; i < size; i++) {
			inorder[i] = scn.nextInt();
		}
		CreateTreeUsingPreorderAndInorder m = new CreateTreeUsingPreorderAndInorder();
		BinaryTree bt1 = m.new BinaryTree();
		bt1.buildTree(inorder, preorder, 0, size-1);
		bt1.printInorder();
		
	}

	private class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	private class BinaryTree {
		Node root;
		int preIndex = 0;

		Node buildTree(int in[], int pre[], int inStrt, int inEnd) {
			if (inStrt > inEnd)
				return null;

			/*
			 * Pick current node from Preorder traversal using preIndex and increment
			 * preIndex
			 */
			Node tNode = new Node(pre[preIndex++]);

			/* If this node has no children then return */
			if (inStrt == inEnd)
				return tNode;

			/* Else find the index of this node in Inorder traversal */
			int inIndex = search(in, inStrt, inEnd, tNode.data);

			/*
			 * Using index in Inorder traversal, construct left and right subtrees
			 */
			tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
			tNode.right = buildTree(in, pre, inIndex + 1, inEnd);

			return tNode;
		}

		/*
		 * Function to find index of value in arr[start...end] The function assumes that
		 * value is present in in[]
		 */
		int search(int arr[], int strt, int end, int value) {
			int i;
			for (i = strt; i <= end; i++) {
				if (arr[i] == value)
					return i;
			}
			return i;
		}
		void printInorder() {
			printInorder(this.root);
		}
		/* This function is here just to test buildTree() */
		void printInorder(Node node) {
			if (node == null)
				return;
			printInorder(node.left);
			System.out.print(node.data + " ");
			printInorder(node.right);
		}
	}
}