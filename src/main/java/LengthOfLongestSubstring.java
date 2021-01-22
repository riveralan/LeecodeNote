/**
 * @author linyongjiang
 * @title 无重复字符的最长子串
 * @url https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @description 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {
    /**
     * 解题思路：滑动窗口
     * 1、每次往回检查重复的
     *  2、当发现重复时，
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int longest = 1;
        int startIndex = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            int j = i - 1;
            for (; j >= startIndex; j--) {
                if (c == s.charAt(j)) {
                    startIndex = j + 1;
                    break;
                }
            }
            longest = Math.max(longest, i - j);
        }
        return longest;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        int abcabcbb = lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew");
        System.out.println(abcabcbb);
    }
}
