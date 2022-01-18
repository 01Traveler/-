#题目开始知道是动态规划的题，开始找推导公式
#很容易推出一个公式为 n 为完全平方数，则为1，不为完全平方数则为上一个完全平方数的组成数加（n-上一个完全平方数）的组成数，对应numSquares_0
#运行发现问题 12 非完全平方数，但是 12 != numSquares(9) + numSquares(3) ，而是等于 numSquares(4)*3
#由12猜测推导式为 min(numSquares(9) + numSquares(3), numSquares(4) + numSquares(8)), 对应为numsSquare_1,推导仍旧会出错
#采用最终的推导式，为从最开始的最小平方数开始，一个一个过直到该数字,求解成功



class Solution:
    #开始的写法
    def numSquares_0(self, n: int) -> int:
        point = 0
        numSquareList = [1]
        for idx in range(n+1):
            if (point+1)**2 == idx:
                numSquareList.append(1)
                point += 1
            else:
                numSquareList.append(numSquareList[point*point] + numSquareList[idx-point])
        return numSquareList[n]

    def numSquares_2(self, n: int) -> int:
        point = 0
        numSquareList = [0]
        for idx in range(1, n+1):
            if (point+1)**2 == idx:
                point += 1
                numSquareList.append(1)
                continue
            else:
                minNum = 999
                for i in range(1, point+1):
                    if numSquareList[i*i] + numSquareList[idx-i*i] < minNum:
                        minNum = numSquareList[i*i] + numSquareList[idx-i*i]
                #print(idx, minNum)
                numSquareList.append(minNum)
        return numSquareList[n]
        
        
if __name__ == "__main__":
    solu = Solution()
    print(solu.numSquares_2(48))