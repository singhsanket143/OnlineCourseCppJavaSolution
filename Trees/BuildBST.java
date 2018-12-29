package Trees;

import java.util.*;

public class BuildBST {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		BuildBST m = new BuildBST();
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			BST bt = m.new BST(arr, n);
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

		public BST(int[] arr, int n) {
			this.root = this.construct(arr, 0, n - 1);
		}

		// constructing BST using sorted array
		private Node construct(int[] sa, int lo, int hi) {
			if (lo > hi) {
				return null;
			}
			int mid = (lo + hi) / 2;
			Node rv = new Node(sa[mid], null, null);
			this.size++;
			rv.left = this.construct(sa, lo, mid - 1);
			rv.right = this.construct(sa, mid + 1, hi);
			return rv;
		}

		// pre order treversal
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
