//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
//
// 在链表类中实现这些功能： 
//
// 
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
// 
//
// 
//
// 示例： 
//
// MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
// 
//
// 
//
// 提示： 
//
// 
// 所有val值都在 [1, 1000] 之内。 
// 操作次数将在 [1, 1000] 之内。 
// 请不要使用内置的 LinkedList 库。 
// 
// Related Topics 设计 链表 
// 👍 210 👎 0


package com.felix.leetcode.editor.cn;

public class DesignLinkedList {
    public static void main(String[] args) {
//        MyLinkedList obj1 = new DesignLinkedList().new MyLinkedList();
//
//        obj1.addAtHead(7);
//        obj1.addAtHead(2);
//        obj1.addAtHead(1);
//        obj1.addAtIndex(3, 0);
//        obj1.deleteAtIndex(2);
//        obj1.addAtHead(6);
//        obj1.addAtTail(4);
//        int i = obj1.get(4);
//        System.out.println(i);
//        obj1.addAtHead(4);
//        obj1.addAtIndex(5, 0);
//        obj1.addAtHead(6);


//        MyLinkedList obj2 = new DesignLinkedList().new MyLinkedList();
//        obj2.addAtIndex(0, 10);
//        obj2.addAtIndex(0, 20);
//        obj2.addAtIndex(1, 30);
//        int i1 = obj2.get(0);
//        System.out.println(i1);


//        MyLinkedList obj3 = new DesignLinkedList().new MyLinkedList();
//        obj3.addAtTail(1);
//        int i2 = obj3.get(0);
//        System.out.println(i2);

        MyLinkedList obj4 = new DesignLinkedList().new MyLinkedList();
        obj4.addAtHead(2);
        obj4.deleteAtIndex(1);
        obj4.addAtHead(2);
        obj4.addAtHead(7);
        obj4.addAtHead(3);
        obj4.addAtHead(2);
        obj4.addAtHead(5);
        obj4.addAtTail(5);
        int i = obj4.get(5);
        System.out.println(i);
        obj4.deleteAtIndex(6);
        obj4.deleteAtIndex(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyLinkedList {
        int val;
        MyLinkedList next;

        MyLinkedList head;
        MyLinkedList tail;


        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            val = -1;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            MyLinkedList current = this.head;
            int i = index;
            while (current.next != null && i > 0) {
                current = current.next;
                i--;
            }
            if (i == 0) {
                return current.val;
            } else {
                return -1;
            }
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            MyLinkedList myLinkedList = new MyLinkedList();
            myLinkedList.val = val;
            myLinkedList.next = head;
            head = myLinkedList;
            next = head;
            if (tail == null) {
                tail = myLinkedList;
            }
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            MyLinkedList myLinkedList = new MyLinkedList();
            myLinkedList.val = val;
            if (tail != null) {
                tail.next = myLinkedList;
            }
            if (head == null) {
                head = myLinkedList;
            }
            if (next == null) {
                next = myLinkedList;
            }
            tail = myLinkedList;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
                return;
            }
            MyLinkedList myLinkedList = new MyLinkedList();
            myLinkedList.val = val;
            MyLinkedList current = this.head;
            int i = index;
            while (current.next != null && i - 1 > 0) {
                current = current.next;
                i--;
            }
            if (i - 1 == 0) {
                // 插入
                if (current.next == null) {
                    tail = myLinkedList;
                }
                myLinkedList.next = current.next;
                current.next = myLinkedList;
            }
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            MyLinkedList current = this.head;
            if (index == 0) {
                this.head = this.head.next;
                this.next = this.next.next;
            } else {
                int i = index;
                while (current.next != null && i - 1 > 0) {
                    current = current.next;
                    i--;
                }
                if (current.next != null && current.next.next == null) {
                    tail = current;
                }
                if (i - 1 == 0 && current.next != null) {
                    // 删除 current
                    MyLinkedList next = current.next;
                    current.next = next.next;
                }
            }
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder().append(val);
            if (next != null) {
                sb.append("->").append(next);
            }
            return sb.toString();
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}