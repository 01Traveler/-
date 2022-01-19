# 反转字符串，将两头的空格去掉
# python有个很粗暴的解法，一行即可以解决
# 其他解法如提取出字符串，存储在栈中，然后pop，在java和c中实现


class Solution:
    def reverseWords(self, s: str) -> str:
        return " ".join(reversed(s.split()))