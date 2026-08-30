# https://leetcode.com/problems/removing-minimum-and-maximum-from-array/description/?envType=daily-question&envId=2026-08-30

class Solution:
    def minimumDeletions(self, nums: List[int]) -> int:
        lengthOfNums=len(nums)
        maxElement=-9874563211
        minElement=9874563211
        delCountForMaxFromLeft=0
        delCountForMaxFromRight=0
        finalDelCount=9874563211
        indexForMinElement=-1
        for i in range(0, lengthOfNums, 1):
            maxElement=max(maxElement, nums[i])
            if nums[i]<=minElement:
                minElement=min(minElement, nums[i])
                indexForMinElement=i
        for i in range(0, lengthOfNums, 1):
            if nums[i]==maxElement:
                delCountForMaxFromLeft+=1
                if indexForMinElement<=i:
                    finalDelCount=min(finalDelCount, delCountForMaxFromLeft)
                if indexForMinElement>i:
                    finalDelCount=min(finalDelCount, indexForMinElement+1)
                    finalDelCount=min(finalDelCount, delCountForMaxFromLeft+(lengthOfNums-indexForMinElement))
                break
            else:
                delCountForMaxFromLeft+=1
        for i in range(lengthOfNums-1, -1, -1):
            if nums[i]==maxElement:
                delCountForMaxFromRight+=1
                if indexForMinElement>=i:
                    finalDelCount=min(finalDelCount, delCountForMaxFromRight)
                if indexForMinElement<i:
                    finalDelCount=min(finalDelCount, lengthOfNums-indexForMinElement)
                    finalDelCount=min(finalDelCount, delCountForMaxFromRight+(indexForMinElement+1))
                break
            else:
                delCountForMaxFromRight+=1
        return finalDelCount
