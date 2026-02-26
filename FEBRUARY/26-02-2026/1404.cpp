class Solution {
public:
    int numSteps(string s) {
        int carry = 0;
        int step = 0;

        for(int i=s.length()-1; i>0; i--){
            int bit = s[i] - '0' + carry;

            if(bit % 2 == 0){
                step += 1;
            }
            else{
                step += 2;
                carry = 1;
            }
        }

        return step + carry;
    }
};