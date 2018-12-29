package Trees;

import java.util.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeBottomView {
	public static void main(String args[]) {
		TreeBottomView m = new TreeBottomView();
		BottomViewOfBinaryTree tree = m.new BottomViewOfBinaryTree();
		tree.createTree();
		tree.printBottomView();
	}

	private class BottomViewOfBinaryTree {

		class TreeNode {
			TreeNode left;
			TreeNode right;
			int val;

			public TreeNode(int x) {
				this.val = x;
			}
		}

		TreeNode root;

		class MapEntry {
			int nodeValue;
			int nodeLevel;

			public MapEntry(int value, int level) {
				nodeValue = value;
				nodeLevel = level;
			}
		}

		private TreeNode createTree() {
			this.root = new TreeNode(1);
			TreeNode n1 = new TreeNode(2);
			TreeNode n2 = new TreeNode(3);
			TreeNode n3 = new TreeNode(4);
			TreeNode n4 = new TreeNode(5);
			TreeNode n5 = new TreeNode(6);
			TreeNode n6 = new TreeNode(7);
			TreeNode n7 = new TreeNode(8);
			TreeNode n8 = new TreeNode(9);
			TreeNode n9 = new TreeNode(10);
			TreeNode n10 = new TreeNode(11);

			root.left = n1;
			root.right = n2;

			n1.left = n3;
			n1.right = n4;

			n2.left = n5;
			n2.right = n6;

			n3.right = n7;

			n4.left = n8;

			n5.right = n9;

			n6.right = n10;

			return root;
		}

		private void fillUpViewMap(TreeNode currentNode, int currLevel, int horizontalDistFromRoot, Map viewMap) {
			if (currentNode == null)
				return;

			MapEntry mapEntry = (MapEntry) viewMap.get(new Integer(horizontalDistFromRoot));

			if (mapEntry != null) // if node exists at same horizontal distance from root
			{
				// update the view map only if current node is at lower or equal level than
				// already existing one
				if (currLevel >= mapEntry.nodeLevel) {
					MapEntry nodeEntry = new MapEntry(currentNode.val, currLevel);
					viewMap.put(horizontalDistFromRoot, nodeEntry);
				}
			} else // update viewMap with current node entry
			{
				MapEntry nodeEntry = new MapEntry(currentNode.val, currLevel);
				viewMap.put(horizontalDistFromRoot, nodeEntry);
			}

			// fill up view map for left sub-tree
			fillUpViewMap(currentNode.left, currLevel + 1, horizontalDistFromRoot - 1, viewMap);

			// fill up view map for right sub-tree
			fillUpViewMap(currentNode.right, currLevel + 1, horizontalDistFromRoot + 1, viewMap);
		}

		private void printBottomView() {
			Map<Integer, MapEntry> viewMap = new TreeMap<>();

			fillUpViewMap(root, 0, 0, viewMap);

			// print map entries to print the bottom view
			Iterator<Entry<Integer, MapEntry>> iterator = viewMap.entrySet().iterator();

			while (iterator.hasNext()) {
				Entry<Integer, MapEntry> nodeEntry = iterator.next();
				System.out.print("  " + nodeEntry.getValue().nodeValue);
			}
		}
	}

}