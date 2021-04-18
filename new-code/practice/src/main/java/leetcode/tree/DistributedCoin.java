package leetcode.tree;

/**
 * @author mohammed.sh Created on 2021-04-18 https://leetcode.com/problems/distribute-coins-in-binary-tree/
 */
public class DistributedCoin {

  private int result;

  public int distributeCoins(final TreeNode root) {
    result = 0;
    dfs(root);
    return result;
  }

  private int dfs(final TreeNode node) {
    if (node == null) {
      return 0;
    }

    int left = dfs(node.getLeft());
    int right = dfs(node.getRight());

    result = Math.abs(left) + Math.abs(right);
    return node.getVal() + left + right - 1;
  }

}


class TreeNode {

  private int val;
  private TreeNode left;
  private TreeNode right;

  TreeNode() {
  }

  TreeNode(final int val) {
    this.val = val;
  }

  TreeNode(final int val, final TreeNode left, final TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public int getVal() {
    return val;
  }

  public void setVal(final int val) {
    this.val = val;
  }

  public TreeNode getLeft() {
    return left;
  }

  public void setLeft(final TreeNode left) {
    this.left = left;
  }

  public TreeNode getRight() {
    return right;
  }

  public void setRight(final TreeNode right) {
    this.right = right;
  }
}
