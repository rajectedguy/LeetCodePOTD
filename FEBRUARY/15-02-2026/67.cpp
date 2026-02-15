class Solution {
public:
    string addBinary(string a, string b) {

        string result = "";
        int carry = 0;
        int char_a = 0;
        int char_b = 0;
        int sum = 0;

        reverse(a.begin(), a.end());
        reverse(b.begin(), b.end());

        if(a.size() > b.size()){
            int diff = a.size() - b.size();
            for(int i = 0; i < diff; i++) b = b + '0';
        }
        else if(a.size() < b.size()){
            int diff = b.size() - a.size();
            for(int i = 0; i < diff; i++) a = a + '0';
        }

        for(int i = 0; i < a.size(); i++){
            char_a = a[i] - '0';
            char_b = b[i] - '0';
            sum = char_a + char_b + carry;

            if(sum == 0) result = result + '0';
            else if(sum == 1){
                result = result + '1';
                carry = 0;
            }
            else if(sum == 2){
                result = result + '0';
                carry = 1;
            }
            else if(sum == 3){
                result = result + '1';
                carry = 1;
            }
        }

        if(carry == 1) result = result + '1';

        reverse(result.begin(), result.end());
        return result;
    }
};