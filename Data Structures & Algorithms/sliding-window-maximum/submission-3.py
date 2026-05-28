class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        output = []
        maxheap = []

        for l in range(len(nums)):
            heapq.heappush(maxheap, (-nums[l], l))
            
            if l >= k - 1:
                while maxheap[0][1] <= l - k:
                    heapq.heappop(maxheap)
                output.append(-maxheap[0][0])

        return output
        