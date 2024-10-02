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
    public int kthSmallest(TreeNode root, int k) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();

        int res = 0;
        TreeNode cur = root;

        while(cur != null || !q.isEmpty()) {
            while(cur != null){
                q.push(cur);
                cur = cur.left;
            }
            cur = q.pop();
            res++;
            
            if (res == k){
                return cur.val;
            }
            cur = cur.right;
        }
        
        return 0;
    
    }
}