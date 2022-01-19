#题目描述为不使用if、while等标识符和三目运算符实现1-n的加法
#解题思路为利用递归，但是递归的边界条件返回不好实现，考虑利用与运算的阻断性质来进行返回
class Solution:

    sums = 0

    def sumSub(self, n):
        self.sums += n
        return True

    def sumNums(self, n: int) -> int:
        n > 0 and self.sumSub(n) and self.sumNums(n-1)
        return self.sums