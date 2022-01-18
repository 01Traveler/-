#丑数为质因子为2、3、5的数，求解第n个丑数
#初始思路为循环，用一个数记录丑数个数，直到丑数个数达到退出
#上述解法的时间复杂度较高
#换种思路解法，类似于动态规划，维护3个指针，分别指向2、3、5的基数，则下一个丑数必定为num[i] * basej 的最小值，赋值后将指针向后移动一位即可求解

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        items = [0,1]
        p2, p3, p5 = 1,1,1
        for i in range(2,n+1):
            num2,num3,num5 = items[p2]*2, items[p3]*3, items[p5]*5
            limit = min([num2, num3, num5])
            items.append(limit)
            if limit == num2:
                p2+=1
            if limit == num3:
                p3+=1
            if limit == num5:
                p5+=1
        return items[n]