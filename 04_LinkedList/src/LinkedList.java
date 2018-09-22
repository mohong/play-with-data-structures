public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead; // 虚拟头节点
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);   // 唯一的虚拟头节点
        size = 0;
    }

    /**
     * 获取链表的长度
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 链表是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在索引为Index(从0开始)的位置添加一个元素
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {    // index可以取到size,即表示在链表的末尾添加一个元素
            throw new IllegalArgumentException("remove faild. index is illegal");
        }
        Node prev = dummyHead;
        for (int i = 0;  i < index; i++) {
            prev =  prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

        // or

        prev.next = new Node(e, prev.next);

        size++;
    }


    /**
     * 向链表头添加元素e
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表末尾添加一个元素
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获得链表的第index位置的元素
     * @param index 从0开始
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size) {    // index可以取到size,即表示在链表的末尾添加一个元素
            throw new IllegalArgumentException("get faild. index is illegal");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获得链表的第一个元素
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获得链表的最后一个元素
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表中index位置的值
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {    // index可以取到size,即表示在链表的末尾添加一个元素
            throw new IllegalArgumentException("set faild. index is illegal");
        }
        Node cur = dummyHead.next;  // 因为是要找到该索引所对应的元素，所以从第一个有效的节点dummyHead.next开始遍历。
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否存在元素e
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除元素
     * @param index 从0开始
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index > size) {    // index可以取到size,即表示在链表的末尾添加一个元素
            throw new IllegalArgumentException("set faild. index is illegal");
        }
        Node prev = dummyHead;  // 因为是获取该索引的前一个元素，所以从dummyHead开始遍历
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        E retNode = prev.next.e;
        prev.next = prev.next.next;
        prev.next = null;
        size--;
        return retNode;
    }

    /**
     * 删除第一个元素
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     * @return
     */
    public E removeLast() {
        return remove(size -1 );
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
