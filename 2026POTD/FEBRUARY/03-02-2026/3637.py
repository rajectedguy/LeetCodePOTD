class Solution:
    def isTrionic(self, nums: List[int]) -> bool:
        increasing = None
        ic = 0
        dc = 0
        for i in range(1, len(nums)):
            if nums[i] > nums[i-1] and increasing != True:
                ic += 1
                increasing = True
            elif nums[i] < nums[i-1] and increasing != False:
                dc += 1
                increasing = False
            elif nums[i] == nums[i-1]:
                return False
        
        return ic == 2 and dc == 1