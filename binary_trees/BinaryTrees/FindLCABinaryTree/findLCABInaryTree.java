class Solution {

    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        //check for base condition when root is null
        if(root == null) {
            return null
        }
        //check for condition when either or p or q is root, LCA is root in this case
        if(p == root || q == root) {
            return root;
        }
        //search for p and q in left subtree
        TreeNode left = LCA(root.left,p,q);
        //search for p and q in right subtree
        TreeNode right = LCA(root.right,p,q);
        //if both left and right searches return null, then return null
        if(left == null && right == null) {
            return null;
        }

        //if left is not null and right is not null, then returh root
        if(left != null && right != null) {
            return root;
        }
        
        //if left isnull , the return right or else return left.
        return left == null ? right : left;
    }



}
