//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 2996 👎 0


package com.felix.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] ints = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution.threeSum(ints);
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            for (int a = 0; a < nums.length; a++) {
                if (a > 0 && nums[a] == nums[a - 1]) {
                    continue;
                }
                int c = nums.length - 1;
                for (int b = a + 1; b < nums.length; b++) {
                    if (b > a + 1 && nums[b] == nums[b - 1]) {
                        continue;
                    }
                    while (b < c && nums[a] + nums[b] > -nums[c]) {
                        c--;
                    }
                    if (b == c) {
                        break;
                    }
                    if (nums[a] + nums[b] + nums[c] == 0) {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[a]);
                        item.add(nums[b]);
                        item.add(nums[c]);
                        result.add(item);
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}