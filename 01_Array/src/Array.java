public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在所有元素后添加一个新元素
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在所有元素前添加一个新元素
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在第index个位置添加一个新元素
     * @param index 从0开始
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size ) {
            throw new IllegalArgumentException("add faild. require index >= 0 && index <= size");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取index索引位置的元素
     * @param index 从0开始
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get faild. index is illegal");
        }
        return data[index];
    }


    public E getLast() {
        return get(size - 1);
    }


    public E getFirst() {
        return get(0);
    }

    /**
     * 修改Index索引处的元素
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set faild. index is illegal");
        }
        data[index] = e;
    }

    /**
     * 数组中是否存在某个元素
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找某个元素，若存在，返回其索引值，不存在返回-1
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除指定索引下的元素
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove faild. index is illegal");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;  // 方便垃圾回收 loitering object

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
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
        return remove(size -1);
    }

    /**
     * 删除指定元素
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("stack.Array: size = %d, capacity= %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    /**
     * 重置数组，实现动态函数
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}
