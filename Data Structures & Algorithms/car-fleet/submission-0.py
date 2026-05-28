class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        stack = []
        cars = [(pos, sp) for pos, sp in zip(position,speed)]
        cars.sort(reverse=True)

        for i in range(len(position)):
            time = (target - cars[i][0])/ cars[i][1]
            stack.append(time)

            if len(stack) >= 2 and time <= stack[-2]:
                stack.pop()
        
        return len(stack)
