/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public TreeNode findNode(TreeNode root, int b) {
        if(root.val == b) {
            return root;
        }
        
        if(root.val < b) {
            return findNode(root.right,b);
        } else {
            return findNode(root.left,b);
        }
    }
    
    public TreeNode getSuccessor(TreeNode a, int b) {
        //base case when node is null
        if(a == null) {
            return null;
        }
        //find the node having value as b
        TreeNode node = findNode(a, b);
        //initialise prev , successor as null and ancestor as the root of the tree
        TreeNode prev = null;
        TreeNode ancestor = a;
        TreeNode successor = null;
        //if value not found for b, then return null
        if(node == null) {
            return null;
        }
        
        else if(node.right != null) {
            //if right child of node is not null, then
            // we simply find the minimum element in the right subtree of the node
            prev = node.right;
            TreeNode temp = node.right;
            while(temp != null){
                prev = temp;
                temp = temp.left;
            }
            return prev;
        } else {
            //if right child is null for the tree, then we do as follows
            //while ancestor is not null, 
            // if value of ancestor is greater than the b node, then we initialise the
            // successor to be the ancestor and look for a value in the left subtree of 
            // the ancestor where the value of successor might be smaller than the value of ancestor
            // and obviously greater than the value of b
            // if the value of ancestor is smaller than value of b, then we look for the value
            // on the right of the ancestor
            
            while(ancestor != node) {
                if(ancestor.val < b) {
                    ancestor = ancestor.right;
                }
                else {
                    successor = ancestor;
                    ancestor = ancestor.left;
                }
            }
        }
        
        return successor;
    }
}

