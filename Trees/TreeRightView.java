package Trees;

public class TreeRightView {

    public static void main(String args[]) {
       
    }
    private class Node 
    { 
        int data; 
        Node left, right; 
    
        public Node(int item) 
        { 
            data = item; 
            left = right = null; 
        } 
    } 
  
/* Class to print the left view */
    private class BinaryTree 
    { 
        Node root; 
         int  max_level = 0; 
    
        // recursive function to print left view 
        void leftViewUtil(Node node, int level) 
        { 
            // Base Case 
            if (node==null) return; 
    
            // If this is the first node of its level 
            if (max_level < level) 
            { 
                System.out.print(" " + node.data); 
                max_level = level; 
            } 
    
            // Recur for left and right subtrees 
            leftViewUtil(node.left, level+1); 
            leftViewUtil(node.right, level+1); 
        } 
    
        // A wrapper over leftViewUtil() 
        void leftView() 
        { 
            leftViewUtil(root, 1); 
        } 
    }
}