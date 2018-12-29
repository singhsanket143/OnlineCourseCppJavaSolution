package Trees;

import java.util.*;
import java.util.Map.Entry;

public class TreeTopView {
	public static void main(String args[]) {
		// System.out.println("Hello World!");
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	// function should print the topView of
	// the binary tree
	private void TopView(Node root) {
		class QueueObj {
			Node node;
			int hd;

			QueueObj(Node node, int hd) {
				this.node = node;
				this.hd = hd;
			}
		}
		Queue<QueueObj> q = new LinkedList<QueueObj>();
		Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>();

		if (root == null) {
			return;
		} else {
			q.add(new QueueObj(root, 0));
		}

		System.out.println("The top view of the tree is : ");

		// count function returns 1 if the container
		// contains an element whose key is equivalent
		// to hd, or returns zero otherwise.
		while (!q.isEmpty()) {
			QueueObj tmpNode = q.poll();
			if (!topViewMap.containsKey(tmpNode.hd)) {
				topViewMap.put(tmpNode.hd, tmpNode.node);
			}

			if (tmpNode.node.left != null) {
				q.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1));
			}
			if (tmpNode.node.right != null) {
				q.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1));
			}

		}
		for (Entry<Integer, Node> entry : topViewMap.entrySet()) {
			System.out.print(entry.getValue().data);
		}
	}
}
