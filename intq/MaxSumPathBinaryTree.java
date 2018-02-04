package week6.intq;
/*Interview Question 2 - Max Sum Path in Binary Tree
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

Example :

Given the below binary tree,

   1
  / \
 2   3
Return 6.
*/
public class MaxSumPathBinaryTree {

    int INVALID = -10000;
    int max;
    public int maxPathSum(TreeNode A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        max = INVALID;
        if(A == null) return 0;

        int ret = maxPathSumHelper(A);

        if(ret > max) max = ret;
        return max;
    }

    public int maxPathSumHelper(TreeNode A) {

        if(A == null) return INVALID;

        int left = maxPathSumHelper(A.left);
        int right = maxPathSumHelper(A.right);

        // find out the max sum
        if(max < left )
            max = left;

        if(max < right)
            max = right;

        if(max < (A.val + left + right))
            max = A.val + left + right;

        return Math.max(A.val, Math.max(A.val + left, A.val + right));

    }
    public static void main(String[] args){
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        //tree.left.left = new TreeNode(11);
        //tree.left.left.right = new TreeNode(2);
        //tree.left.left.left = new TreeNode(7);

        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(13);
        tree.right.right = new TreeNode(4);

        //tree.right.right.right = new TreeNode(1);

        System.out.println(new MaxSumPathBinaryTree().maxPathSum(tree));
        //System.out.println(new MaxSumPathBinaryTree().maxPathSum1(tree));

    }
    // Time complexity is O(n)
    public int maxPathSum1(TreeNode A) {

        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        calculateSum(A, max);
        return max[0];

    }

    public int calculateSum(TreeNode node, int[] max){

        if(node == null)
            return 0;

        int left = calculateSum(node.left,max);
        int right = calculateSum(node.right, max);

        int current = Math.max(node.val, Math.max(node.val + left, node.val + right));

        max[0] = Math.max(max[0], Math.max(current, left + node.val + right));
        return current;
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
        left=null;
        right=null;
    }
}
