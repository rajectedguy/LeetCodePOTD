class Solution {
public:
    int minimumDeletions(string s) {
        stack<char> stk;int count=0;
        for(char ch:s){
            if(!stk.empty() && stk.top()=='b' && ch=='a'){
                stk.pop();
                count++;
            }
            else{
                stk.push(ch);
            }
        } 
        return count;
    }
};