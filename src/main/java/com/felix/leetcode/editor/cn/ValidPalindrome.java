//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 339 👎 0

package com.felix.leetcode.editor.cn;

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        boolean palindrome = solution.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            int i = 0;
            int j = s.length() - 1;
            while (i <= j) {
                if (!checkChar(s.charAt(i))) {
                    i++;
                    continue;
                }
                if (!checkChar(s.charAt(j))) {
                    j--;
                    continue;
                }
                if (!compareChar(s.charAt(i), s.charAt(j))) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }

        public boolean checkChar(char c) {
            return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
        }

        public boolean compareChar(char a, char b) {
            if (a < 'a') {
                a += 'a' - 'A';
            }
            if (b < 'a') {
                b += 'a' - 'A';
            }
            return a == b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}