/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int[] pre, in;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) return null;
        pre = Arrays.copyOf(preorder, preorder.length);
        in = Arrays.copyOf(inorder, inorder.length);
        return build(0, preorder.length, 0, inorder.length);

    }

    public TreeNode build(int preStart, int preEnd, int inStart, int inEnd){
        if (preStart == preEnd || preStart == pre.length) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int mid = Arrays.asList(in).indexOf(root);

        for (int index = inStart; index < inEnd; index++){
            if (in[index] == root.val){
                mid = index - inStart;
                break;
            }
        }

        root.left = build( preStart + 1, preStart + mid + 1, inStart, inStart + mid);
        root.right = build(preStart + mid + 1, preEnd, inStart + mid + 1, inEnd);
        return root;
    }   
}