#一段长度为n的绳子，如何剪可以使各段绳子的乘积最大
#未解答出来
#解法核心有两个点，第一为根据公式推导出n段绳子长度相等时乘积最大 第二为利用微积分求解极值点的绳子长度为3，即解答出答案

class Solution:
    def cuttingRope(self, n: int) -> int:
        if n < 4:
            return n-1
        b = n%3
        a= int(n/3)
        if b == 0:
            return 3**a
        elif b == 1:
            return (3**(a-1))*4
        else:
            return (3**a)*2