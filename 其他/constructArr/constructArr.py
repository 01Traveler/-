#给定一个数组，返回乘积数组，i处乘积定义为除i处的其他项的乘积，不可以使用除法
#题目类型为前缀和，根据公式有   result[i] = prefix[i-1] * suffix[i+1]，故只需要维护两个数组即可以求解

class Solution:
    def constructArr(self, a: List[int]) -> List[int]:
        aLen = len(a)
        if aLen < 2:
            return a
        prefix = [item for item in a]
        suffix = [item for item in a]
        result = [1] * aLen
        for idx in range(1, aLen):
            prefix[idx] = prefix[idx] * prefix[idx-1]
        for idx in range(aLen-2,0,-1):
            suffix[idx] = suffix[idx+1] * suffix[idx]
        result[0] = suffix[1]
        result[-1] = prefix[aLen-2]
        for idx in range(1, aLen-1):
            result[idx] = suffix[idx+1] * prefix[idx-1]
        return result