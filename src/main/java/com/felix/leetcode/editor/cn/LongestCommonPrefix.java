//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1470 👎 0


package com.felix.leetcode.editor.cn;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
//        String[] strings = {"flower", "flow", "flight"};
//        String[] strings = {"dog", "racecar", "car"};
//        String[] strings = {};
        String[] strings = {"cir", "car"};
        String s = solution.longestCommonPrefix(strings);
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder result = new StringBuilder();
            if (strs.length < 1) {
                return result.toString();
            }
            // 求最小值
            int strmix = strs[0].length();
            for (int i = 0; i < strs.length; i++) {
                strmix = Math.min(strmix, strs[i].length());
            }
            // 字母顺序
            for (int j = 0; j < strmix; j++) {
                char c = 0;
                boolean check = true;
                for (int k = 0; k < strs.length && check; k++) {
                    if (c == 0) {
                        c = strs[k].charAt(j);
                    } else {
                        if (c != strs[k].charAt(j)) {
                            check = false;
                        }
                    }
                }
                if (check) {
                    result.append(c);
                } else {
                    return result.toString();
                }
            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}