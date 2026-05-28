class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for row in board:
            counts = defaultdict(int)
            for i in row:
                if i != '.':
                    counts[i] += 1
                
                if counts[i] > 1:
                    return False
        
        for i in range(len(board)):
            counts = defaultdict(int)
            for j in range(len(board)):
                if board[j][i] != '.':
                    counts[board[j][i]] += 1

                if counts[board[j][i]] > 1:
                    return False    
            
        for reg in range(len(board)):
            counts = defaultdict(int)
            for i in range(3):
                for j in range(3):
                    r = (reg // 3) * 3 + i
                    c = (reg % 3) * 3 + j

                    if board[r][c] != '.':
                        counts[board[r][c]] += 1
                    
                    if counts[board[r][c]] > 1:
                        return False
        
        return True

 






        
            
