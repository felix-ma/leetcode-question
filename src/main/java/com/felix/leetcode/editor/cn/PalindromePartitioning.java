//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 492 👎 0


package com.felix.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        List<List<String>> aab = solution.partition("cdd");
        System.out.println(aab);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<>();
            dfs(s, 0, new ArrayList<>(), result);
            return result;
        }

        public void dfs(String s, int start, List<String> item, List<List<String>> result) {
            // 递归退出条件
            if (start == s.length()) {
                result.add(new ArrayList<>(item));
                return;
            }
            // 递归
            for (int i = start; i < s.length(); i++) {
                String sub = s.substring(start, i + 1);
                if (!isPartition(sub)) {
                    continue;
                }
                item.add(sub);
                dfs(s, i + 1, item, result);
                item.remove(item.size() - 1); // 此处要从尾删
            }
        }

        public boolean isPartition(String s) {
            if (s == null || s.length() == 1) {
                return true;
            }
            int i = 0;
            int j = s.length() - 1;
            while (i <= j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}