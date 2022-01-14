//数组中仅有一个数字出现超过一半次数，找出这个数字
//绝妙的解法，采用的类似比较删除的方式，将两个不同的元素删除，最后留下的一定是超过一半次数的数字
//时间复杂度为O(n)，空间复杂度为O(1)

class Solution {
    public int majorityElement(int[] nums) {
        int x=nums[0];
        int cnt=0;
        for(int i : nums){
            if(cnt == 0){
                x = i;
                cnt = 1;
            }
            else if(x != i){
                cnt --;
            }
            else if(x==i){
                cnt++;
            }
        }
        return x;
    }
}
