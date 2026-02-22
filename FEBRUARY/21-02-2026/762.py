class Solution:
    def countPrimeSetBits(self, left: int, right: int) -> int:
        setBits = {2,3,5,7,11,13,17,19}
        count = 0 
        
        for i in range(left, right + 1): 
            onecount = i.bit_count()

            if onecount in setBits: 
                count += 1 
        
        return count