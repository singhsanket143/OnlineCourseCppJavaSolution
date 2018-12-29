package Trees;

import java.util.*;
public class PrintBSTkeysInGivenRange {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		PrintBSTkeysInGivenRange m = new PrintBSTkeysInGivenRange();
        int t = scn.nextInt();
        while(t-- > 0){
            int n =scn.nextInt();
            BST bt = m.new BST(n);
            bt.preorder();
             int k1 =scn.nextInt();
             int k2 =scn.nextInt();
             bt.inrange(k1,k2);
            
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
        private Node insertInBst(Node root,int d){
            if(root==null){
                return new Node(d,null,null);
            }
            //Rec Case
            if(d<root.data){
                root.left = insertInBst(root.left,d);
            }
            else{
                root.right = insertInBst(root.right,d);
            }
            return root;
        }

        // constructing BST 
        private Node construct(int n) {
            
            Node root = null;
            int i=0;
            while(i<n){
                int d=scn.nextInt();
                root = insertInBst(root,d);
                i++;
            }
            return root;
        }
        // pre order treversal
        public void preorder() {
            System.out.print("# Preorder : ");
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

            
         public void inrange(int lo, int hi) {
             System.out.print("# Nodes within range are : ");
            this.inrange(this.root, lo, hi);
            System.out.println();
        }

        void inrange(Node node, int k1, int k2) { 
            /* base case */
            if (node == null) { 
                return; 
            } 
            if (k1 < node.data) { 
                inrange(node.left, k1, k2); 
            } 
            /* if root's data lies in range, then prints root's data */
            if (k1 <= node.data && k2 >= node.data) { 
                System.out.print(node.data + " "); 
            } 
            /* If root->data is smaller than k2, then only we can get o/p keys 
            in right subtree */
            if (k2 > node.data) { 
                inrange(node.right, k1, k2); 
            } 
        } 
    }

}
 