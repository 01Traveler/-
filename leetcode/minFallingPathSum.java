//int[m][n] 
//二维数组路径下降最小和
//力扣有很多类似的题目，主要思路就是动态规划，下一层的结果取决于上一层的结果
//推导公式考虑边界，即idx=0和idx=n-1的状况，剩余为Math.min(Math.min(steps[j-1], steps[j]), steps[j+1]) + tmp[j]，即上一层可达的最小值
//时间复杂度为O(mn), 空间复杂度为O(n)

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[] steps = matrix[0];
        for(int i=1;i<matrix.length;i++){
            int[] tmp= matrix[i];
            for(int j=0;j<matrix[0].length;j++){
                if(j==0) tmp[j] = Math.min(steps[j], steps[j+1]) + tmp[j];
                else if(j==matrix[0].length-1) tmp[j] = Math.min(steps[j-1], steps[j]) + tmp[j];
                else tmp[j] = Math.min(Math.min(steps[j-1], steps[j]), steps[j+1]) + tmp[j];
            }
            steps = tmp;
        }
        Arrays.sort(steps);
        return steps[0];
    }
}
