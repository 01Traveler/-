class TreeNode{
	int val;
	int left = null;
	int rigth = null;
	public TreeNode(int x) {val = x;}
}


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode parent = root;
        TreeNode left = p.val > q.val ? q : p;
        TreeNode right = p.val > q.val ? p : q;
        while(parent != null){
            if(left.val < parent.val && right.val < parent.val) parent = parent.left;
            else if(left.val > parent.val && right.val > parent.val) parent = parent.right;
            else break;
        }
        return parent;
    }
	
}



class Solution {
    private TreeNode parent;

    private boolean TreeNodeSub(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;
        boolean inLeft = TreeNodeSub(root.left, p, q);
        boolean inRight = TreeNodeSub(root.right, p, q);
        boolean inSons = inLeft && inRight;
        boolean inSon = inRight || inLeft;
        boolean inSelf = (root.val == p.val || root.val == q.val);
        if(inSons || (inSon && inSelf)) parent = root;
        return inLeft || inRight || inSelf;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNodeSub(root, p, q);
        return parent;
    }
}