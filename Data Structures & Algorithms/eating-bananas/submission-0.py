class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left = 1
        right = max(piles)

        minRate = float('inf')

        while left <= right:
            rate = left + ((right - left) // 2)

            curr = 0
            for pile in piles:
                curr += math.ceil(float(pile)/rate) 
            
            if curr > h:
                left = rate + 1
            elif curr <= h:
                right = rate - 1
                minRate = min(minRate, rate)

        return minRate