// Definition for a binary tree node.
public class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode parent;
 TreeNode(int x) { val = x; }
}
 
public class BinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return height(root, 1) >= 0;
    }
    
    public int height(TreeNode root, int height) {
        
        if (height < 0) {
            return -1;
        }
        if (root == null) {
            return height;
        }
        int leftHeight = height(root.left, height + 1);
        int rightHeight = height(root.right, height + 1);
        
        return Math.abs(leftHeight - rightHeight) <=1 ? Math.max(leftHeight, rightHeight) : -1;
    }
    
    public TreeNode nextInOrder(TreeNode node, boolean recursive) {
      if (node == null) {
        return null;
      } else if (node.right == null) {
        return node.Parent;
      } else {
        if (recursive) {
          return FindNext(node.right);
        } else {
          TreeNode next = null;
          node = node.right;
          while(node != null) {
            next = node;
            node = node.left;
          }
          return next;
        }
      }
    }
    
    public TreeNode findNext(TreeNode node) {
      if (node.left == null) {
        return node;
      } else {
        return findNext(node.left);
      }
    }
    
    public TreeNode createTree(int[] tree, boolean parent) {
      TreeNode parent = null;
      for (int nodeVal: tree) {
        
      }
    }
    
    public static void main(Sting[] args) {
        
    }
}