class Solution {
    /**
    解题思路：动态规划+哈希表
    1、状态：设dp[j] 为以j为结尾的最大字符串长度，i为j左边的相同字符
    2、转移方程推导
    当i<0时，即j左边不存在相同的i,dp[j]= dp[j-1]+1;
    当dp[j]<j-i,即i不在dp[j]代表的最大字符串内，故dp[j]= dp[j-1]+1;
    当dp[j]>=j-1,即i在dp[j]代表的最大字符串内，故dp[j]= j - i;
    故得到状态转移方程为
    dp[j]= dp[j-1]+1,当dp[j]<j-i
    dp[j]= j - i,当dp[j]>=j-1

    又因为减少i的寻找时间，使用哈希表记录每次字符出现的最后一次索引位

    **/
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int maxLength = 0, lastLength = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            lastLength = lastLength < j - i ? lastLength + 1 : j - i; // dp[j]= dp[j-1]+1,当dp[j]<j-i；dp[j]= j - i,当dp[j]>=j-1
            maxLength = Math.max(maxLength, lastLength); // max(dp[j - 1], dp[j])
        }
        return maxLength;
    }
}