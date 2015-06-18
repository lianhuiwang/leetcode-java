package Binary_Search_Tree_Iterator;

import java.util.ArrayDeque;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * @author lianhui
 *
 */
public class Binary_Search_Tree_Iterator {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public class BSTIterator {

    private ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
    
    public BSTIterator(TreeNode root) {
      TreeNode node = root;
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
      return stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
      TreeNode node = stack.pop();
      int value = node.val;
      node = node.right;
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
      return value;
    }
  }
  
}
