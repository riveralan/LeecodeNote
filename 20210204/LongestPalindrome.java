public class LongestPalindrome {
    /**
     * 动态规划
     * 1、当子串长度为1，那么肯定是回文
     * 2、当子串长度为2，那么只要子串字符相等，那么就是回文
     * 3、假设dp[i+1,j-1]是回文，那么只有s[i]==s[j]时，dp[i,j]才是回文
     * 4、子串回文向长度增加转移，则动态转移方程为：dp[i,j] = dp[i+1,j-1] | s[i]=s[j]
     * 5、取最长的字符串
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        String subString = "";
        //按长度扫描
        for (int len = 0; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                if (len == 0
                        || len == 1 && s.charAt(i) == s.charAt(j)
                        || dp[i + 1][j - 1] == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 1;
                    if (j - i + 1 >= subString.length()) {
                        subString = s.substring(i, j + 1);
                    }
                }
            }
        }
        return subString;
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String babad = longestPalindrome.longestPalindrome("babad");
        System.out.println(babad);
    }
}
