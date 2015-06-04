package Binary_Tree_Right_Side_View;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
      List<Integer> results = new ArrayList<Integer>();
      List<TreeNode> level = new ArrayList<TreeNode>();
      if (root != null) {
        level.add(root);
      }

      while (!level.isEmpty()) {
        results.add(level.get(level.size() - 1).val);
        List<TreeNode> nextLevel = new ArrayList<TreeNode>();
        for (TreeNode node : level) {
          if (node.left != null) {
            nextLevel.add(node.left);
          }
          if (node.right != null) {
            nextLevel.add(node.right);
          }
        }
        level = nextLevel;
      }
      return results;
    }
  }
  
  public static void main(String[] args) {
    
  }
  
}
