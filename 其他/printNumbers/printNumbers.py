#输入n，打印所有n位的数字，不包含0

class Solution:
    def printNumbers(self, n: int) -> List[int]:
        return list(range(1,10**n))