class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        total = len(nums1) + len(nums2)
        half = total//2

        if len(nums1) < len(nums2):
            smaller = nums1
            bigger = nums2
        else:
            smaller = nums2
            bigger = nums1

        l = 0
        r = len(smaller) - 1

        while True:
            i = (l+r) // 2
            j = half - i - 2

            if i >= 0:
                smallerLeft = smaller[i]
            else:
                smallerLeft = float('-inf')
            
            if i + 1 < len(smaller):
                smallerRight = smaller[i + 1]
            else:
                smallerRight = float('inf')

            if j >= 0:
                biggerLeft = bigger[j]
            else:
                biggerLeft = float('-inf')
            
            if j + 1 < len(bigger):
                biggerRight = bigger[j+1]
            else:
                biggerRight = float('inf') 
            
            if smallerLeft <= biggerRight and biggerLeft <= smallerRight:
                if total % 2 != 0:
                    return min(biggerRight, smallerRight)
                else:
                    return (max(biggerLeft, smallerLeft) + min(smallerRight, biggerRight))/2
            elif smallerLeft > biggerRight:
                r = i - 1
            else:
                l = i + 1
        





            