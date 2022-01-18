#没有解出来
#环形数组最大和
#解法分为两种情况，一、最大和出现在数组中间，则采用普通的动态规划即可解答；二、最大和出现在首尾，则可以转化为求中间的最小和，可以看作双指针往中间推，直到出现负数为止
#特殊情况为最大和小于0，此时最大值为一个元素




class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        maxVal,minVal = -99999,99999
        curMax,curMin = 0,0
        totalSum = 0
        for i in nums:
            totalSum += i
            curMax = max([curMax+i,i])
            curMin = min([curMin+i, i])
            maxVal = max([curMax, maxVal])
            minVal = min([curMin, minVal])
        return maxVal if maxVal < 0 else max([maxVal, totalSum-minVal])