class Solution {
public:
    bool checkOnesSegment(string s) {
      bool ones=true;
      for(char &ch:s){
        if(ch=='0') ones=false;
        else{
          if(!ones) return false;
        }
      }
      return true;        
    }
};