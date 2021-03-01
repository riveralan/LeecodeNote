import com.sun.deploy.util.StringUtils;

public class Solution {
    public boolean test(String str) {
        if (str != null && str.length() == 0) {
            return true;
        }
        int left = 0, right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.test("car");
        System.out.println(result);
    }
}
