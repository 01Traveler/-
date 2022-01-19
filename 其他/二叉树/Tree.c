struct TreeNode{
	int val;
	struct TreeNode* left;
	struct TreeNode* right;
}


struct TreeNode* lowestCommonAncestor(struct TreeNode* root, struct TreeNode* p, struct TreeNode* q) {
    struct TreeNode* parent;
    parent = root;
    struct TreeNode* left = p->val > q->val ? q : p;
    struct TreeNode* right = p->val < q->val ? q : p;
    while(parent != NULL){
        if(parent->val > left->val && parent->val > right->val) parent = parent->left;
        else if(parent->val < left->val && parent->val < right->val) parent = parent->right;
        else break;
    }
    return parent;
}






struct TreeNode* parent;

struct TreeNode* lowestCommonAncestorSub(struct TreeNode* root, struct TreeNode* p, struct TreeNode* q){
    if(root == NULL) return false;
    bool inLeft = lowestCommonAncestorSub(root->left, p, q);
    bool inRight = lowestCommonAncestorSub(root->right, p, q);
    bool inSons = inLeft && inRight;
    bool inSon = inLeft || inRight;
    bool inSelf = p->val == root->val || q->val == root->val;
    if(inSons || (inSelf && inSon)) parent = root;
    return inSon || inSelf;
}

struct TreeNode* lowestCommonAncestor(struct TreeNode* root, struct TreeNode* p, struct TreeNode* q) {
    lowestCommonAncestorSub(root, p, q);
    return parent;
}