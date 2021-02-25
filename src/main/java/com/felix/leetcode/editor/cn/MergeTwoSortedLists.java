//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1559 👎 0


package com.felix.leetcode.editor.cn;

import com.felix.leetcode.ListNode;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
//        l1 = [1,2,4], l2 = [1,3,4]

        int[] a = {-30, -30, -28, -25, -24, -23, -23, -21, -19, -19, -19, -18, -14, -14, -13, -10, -10, -9, -8, -7, -3, -2, -1, 2, 3, 5, 7, 8, 10, 13, 14, 16, 16, 17, 17, 18, 21, 23, 25, 26, 27, 28, 29};
        int[] b = {-30, -30, -29, -26, -26, -26, -26, -25, -24, -24, -22, -22, -21, -20, -20, -16, -15, -9, -9, -7, -5, -1, 0, 1, 2, 2, 4, 4, 4, 5, 6, 6, 8, 9, 10, 11, 12, 14, 15, 17, 19, 20, 21, 22, 24, 25, 25, 27, 28};
        ListNode l1 = null;
        ListNode l2 = null;
        for (int i = a.length - 1; i >= 0; i--) {
            ListNode listNode = new ListNode(a[i]);
            listNode.next = l1;
            l1 = listNode;
        }
        for (int i = b.length - 1; i >= 0; i--) {
            ListNode listNode = new ListNode(b[i]);
            listNode.next = l2;
            l2 = listNode;
        }
        ListNode listNode = solution.mergeTwoLists(l1, l2);
        System.out.println(listNode);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return null;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1 == null) {
                return l2;
            }
            ListNode result;
            ListNode append;
            if (l1.val < l2.val) {
                result = l1;
                append = l2;
            } else {
                result = l2;
                append = l1;
            }
            // 遍历result，判断插入节点。遍历append，对比值插入。
            ListNode pre = result;
            while (pre.next != null && pre.next.val <= append.val) {
                pre = pre.next;
            }
            if (pre.next == null) {
                // 直接拼接到最后
                pre.next = append;
                return result;
            } else {
                ListNode start = append;
                while (append.next != null && append.next.val < pre.next.val) {
                    append = append.next;
                }
                ListNode tmp = append.next;
                append.next = pre.next;
                pre.next = start;
                append = tmp;
            }
            return mergeTwoLists(result, append);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}