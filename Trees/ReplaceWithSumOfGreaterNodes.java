package Trees;

import java.util.Scanner;

public class ReplaceWithSumOfGreaterNodes {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		ReplaceWithSumOfGreaterNodes m = new ReplaceWithSumOfGreaterNodes();
		BST b = m.new BST(arr);
		b.modifyBST();
		b.preorder();
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

		public BST(int... sa) {
			this.root = this.construct(sa, 0, sa.length - 1);
		}

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

		public void modifyBST() {
			int[] arr = { 0 };
			this.modifyBSTwithgreaterelementssum(this.root, arr);
		}

		private void modifyBSTwithgreaterelementssum(Node node, int[] sum) {
			if (node == null)
				return;
			modifyBSTwithgreaterelementssum(node.right, sum);
			sum[0] += node.data;
			node.data = sum[0];
			modifyBSTwithgreaterelementssum(node.left, sum);
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