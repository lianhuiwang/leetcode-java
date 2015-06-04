package Binary_Tree_Inorder_Traversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public class TreeNode {
         int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
   
  public class Solution {
    public void traversal(TreeNode node, List<Integer> inOrderList) {
      if (node == null) {
        return;
      }
      if (node.left != null) {
        traversal(node.left, inOrderList);
      }
      inOrderList.add(node.val);
      if (node.right != null) {
        traversal(node.right, inOrderList);
      }
    }
    
      public List<Integer> inorderTraversal(TreeNode root) {
          List<Integer> inOrderTree = new ArrayList<Integer>();
          this.traversal(root, inOrderTree);
          return inOrderTree;
      }
  }
  

}
