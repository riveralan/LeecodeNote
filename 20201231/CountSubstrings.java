public class CountSubstrings {

    /**
     * 解题思路
     * 采用动态规划求解
     * 1.首先需要理解回文子串的含义:
     * 如果一个字符串前后两端对应的子串不相同,那么该字符串一定不是回文子串。
     * 当收尾两端字符相同时,继续递归比较d[i + 1][j - 1]是否是回文子串。
     * 2.按照单个字符、两个字符和多个字符等三个条件依次进行判断。得出动态规划方程为
     * a.单个字符: j == i and s[i] == s[j] => dp[i][j] = true;
     * b.两个字符: j - i == 1 and s[i] == s[j] => dp[i][j] = true;
     * c.多个字符: j - i > 1 and dp[i][j] = dp[i + 1][j - 1] and s[i] == s[j]
     * @param str
     * @return
     */
    public int countSubstrings(String str) {
        int len = str.length();
        boolean[][] dp = new boolean[len][len];
        int count = 0;
        char[] charArray = str.toCharArray();
        for (int j = 0; j < len; j++){
            for (int i = 0; i <= j; i++){
                if (j == i && charArray[j] == charArray[i]){
                    dp[i][j] = true;
                    count++;
                }else if (j - i == 1 && charArray[i] == charArray[j]){
                    dp[i][j] = true;
                    count++;
                }else if (j - i > 1 && dp[i + 1][j - 1] && charArray[i] == charArray[j]){
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
