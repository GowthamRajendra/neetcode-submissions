class TimeMap:

    def __init__(self):
        self.timemap = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.timemap:
            self.timemap[key] = []
        self.timemap[key].append([value,timestamp])

    def get(self, key: str, timestamp: int) -> str:
        values = self.timemap.get(key,[])

        left = 0
        right = len(values) - 1

        val = ''

        while left <= right:
            m = left + ((right - left) // 2)

            if timestamp < values[m][1]:
                right = m - 1
            elif timestamp >= values[m][1]:
                left = m + 1
                val = values[m][0]
            
            
        return val
