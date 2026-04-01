/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void InOrder(TreeNode* root, vector<int>& arr){
        if(!root) return;
        InOrder(root->left, arr);
        arr.push_back(root->val);
        InOrder(root->right, arr);
    }
    TreeNode* getBalanced(vector<int>& values,int l,int r){
        if(l>r) return nullptr;
        int m = (r+l)/2;
        auto left =  getBalanced(values,l,m-1);
        auto right = getBalanced(values,m+1,r);
        return new TreeNode(values[m], left, right);

    }

    TreeNode* balanceBST(TreeNode* root) {
        vector<int> values;
        InOrder(root, values);
        TreeNode* result = getBalanced(values, 0, values.size()-1);
        return result;
    }
    
};