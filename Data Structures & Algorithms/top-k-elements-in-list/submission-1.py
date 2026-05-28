class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freqs = defaultdict(int)

        for num in nums:
            freqs[num] = freqs[num] + 1
        
        output = []

        freqs = dict(sorted(freqs.items(), key=lambda item: item[1]))

        keys = list(freqs.keys())

        for i in range(k):
            output.append(keys.pop())

        return output