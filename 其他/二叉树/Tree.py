class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        

class Solution:
    
    # 二叉树的最近公共祖先
    # 利用二叉树的左边比右边小，从而寻找到分叉点即可
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        parent = root
        left = p if p.val < q.val else q
        right = q if q.val > p.val else p
        while parent!= None:
            if parent.val > left.val and parent.val > right.val:
                parent = parent.left
            elif parent.val < left.val and parent.val < right.val:
                parent = parent.right
            else:
                break
        return parent



class Solution:

    parent = None

    # 和二叉搜索树类似，但是数字是无顺序的，所以无法利用分叉点
    # 解法为递归，每个最小单元有一个返回结果，在最小单元内会做一个判断，如果条件成立则会更新父节点
    def lowestCommonAncestorSub(self, root, p, q):
        if(root == None):
             return False
        inLeft = self.lowestCommonAncestorSub(root.left, p, q)
        inRight = self.lowestCommonAncestorSub(root.right, p, q)
        inSons = inLeft and inRight
        inSon = inRight or inLeft
        inSelf = p.val == root.val or q.val == root.val
        if(inSons or (inSon and inSelf)):
            self.parent = root
        return inSon or inSelf

    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        self.lowestCommonAncestorSub(root, p, q)
        return self.parent