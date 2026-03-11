class Solution:
    def bitwiseComplement(self, n: int) -> int:
        n = bin(n)[2::]
        n1 = ''
        for i in n:
            if i == '1':
                n1 += '0'
            else:
                n1 += '1'
        return int(n1,2)