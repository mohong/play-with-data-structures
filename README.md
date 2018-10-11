# play-with-data-structures

>Java实现常见数据结构，来源于[liuyubobobo](https://github.com/liuyubobobo/Play-with-Data-Structures)老师的课程资料

## 目录

- 01 数组
    - [动态数组](https://github.com/mohong/play-with-data-structures/blob/master/01_Array/src/Array.java)
- 02 栈
    - [数组栈](https://github.com/mohong/play-with-data-structures/blob/master/02_Stack/src/ArrayStack.java)
    - [链表栈](https://github.com/mohong/play-with-data-structures/blob/master/02_Stack/src/LinkedListStack.java)
- 03 队列
    - [数组队列](https://github.com/mohong/play-with-data-structures/blob/master/03_Queue/src/ArrayQueue.java)
    - [链表队列](https://github.com/mohong/play-with-data-structures/blob/master/03_Queue/src/LinkedListQueue.java)
    - [循环队列](https://github.com/mohong/play-with-data-structures/blob/master/03_Queue/src/LoopQueue.java)
- 04 链表
    - [链表](https://github.com/mohong/play-with-data-structures/blob/master/04_LinkedList/src/LinkedList.java)
- 05 二分搜索树
    - [二分搜索树](https://github.com/mohong/play-with-data-structures/blob/master/05_BST/src/BST.java)
- 06 集合
    - [基于链表的集合](https://github.com/mohong/play-with-data-structures/blob/master/06_Set/src/LinkedListSet.java)
    - [基于二分搜索树的集合](https://github.com/mohong/play-with-data-structures/blob/master/06_Set/src/BSTSet.java)
- 07 映射
    - [基于链表的映射](https://github.com/mohong/play-with-data-structures/blob/master/07_Map/src/LinkedListMap.java)
    - [基于二分搜索树的映射](https://github.com/mohong/play-with-data-structures/blob/master/07_Map/src/BSTMap.java)



## [数组](https://github.com/mohong/play-with-data-structures/blob/master/01_Array/src/Array.java)

数组最大的优点是快速查询，入score[2]，缺点是初始化后长度固定，无法动态变化。可以手动实现[动态扩展](https://github.com/mohong/play-with-data-structures/blob/master/01_Array/src/Array.java#L193)。

## [栈](https://github.com/mohong/play-with-data-structures/blob/master/02_Stack/src/Stack.java)

栈是一种线性结构，特点是后进先出。操作有"括号匹配"、"系统栈的调用"、"编辑器的undo操作"等。操作有"压栈弹栈"等。
由于是线性结构，可以通过数组实现[数组栈](https://github.com/mohong/play-with-data-structures/blob/master/02_Stack/src/ArrayStack.java)，也可以通过链表实现[链表栈](https://github.com/mohong/play-with-data-structures/blob/master/02_Stack/src/LinkedListStack.java)。

栈相关的题目

[有效的括号](https://github.com/mohong/leetcode-problems/tree/master/0020-Valid%20Parentheses/src)


## [队列](https://github.com/mohong/play-with-data-structures/blob/master/03_Queue/src/Queue.java)

队列也是一种线性结构，特点是先进先出。只能从队尾添加元素，从队首取出元素，树结构的广度优先遍历使用了这个特性。依然可以通过数组实现[数组队列](https://github.com/mohong/play-with-data-structures/blob/master/03_Queue/src/ArrayQueue.java), 也可以通过链表实现[链表队列](https://github.com/mohong/play-with-data-structures/blob/master/03_Queue/src/LinkedListQueue.java)。数组队列可以优化为[循环队列](https://github.com/mohong/play-with-data-structures/blob/master/03_Queue/src/LoopQueue.java)。
循环队列中声明head为头节点，tail为最后一个节点的下一个节点，size为队列的长度。判断该队列是否为空的条件是`front==tail`，判断是否已满的条件是`(tail+1) % size == front`。

## [链表](https://github.com/mohong/play-with-data-structures/blob/master/04_LinkedList/src/LinkedList.java)

为链表设置虚拟头节点可以更好的处理问题。

虚拟头节点：
设置一个虚拟头节点dummyHead，如果是要通过遍历获取所求节点的前一个节点，则设置成从头节点处开始遍历，即

```
Node prev = dummyHead;

// 遍历操作中更新prev: 

prev = prev.next

```

这样求得的prev表示的就是需要查找的索引值的元素的前一个节点

如果是要通过遍历求该索引所对应的节点，则应该从第一个有效节点开始，即：

```
Node cur = dummyHead.next;

// 便利操作更新cur

cur = cur.next;
```


二叉树：有最对两个叉的树

> 二叉树(Binary Tree)是n(n>=0)个结点的有限集合，该集合或者为空集合（称为空二叉树），或者由一个根结点和两棵互不相交的、分别称为根结点的左子树和右子树的二叉树组成。

二分搜索树：根节点大于
