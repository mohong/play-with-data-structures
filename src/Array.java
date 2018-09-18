public class Array {

    private int[] data;
    private int size;

    public Array(int capacity) {
        data = new int[capacity];
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
    public void addLast(int e) {
        add(size, e);
    }

    /**
     * 在所有元素前添加一个新元素
     * @param e
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 在第index个位置添加一个新元素
     * @param index 从0开始
     * @param e
     */
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("add faild. Array is full");
        }
        if (index < 0 || index > size ) {
            throw new IllegalArgumentException("add faild. require index >= 0 && index <= size");
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
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get faild. index is illegal");
        }
        return data[index];
    }

    /**
     * 修改Index索引处的元素
     * @param index
     * @param e
     */
    public void set(int index, int e) {
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
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
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
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
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
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove faild. index is illegal");
        }
        int ret = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return ret;
    }

    /**
     * 删除第一个元素
     * @return
     */
    public int removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     * @return
     */
    public int removeLast() {
        return remove(size -1);
    }

    /**
     * 删除指定元素
     * @param e
     */
    public void removeElement(int e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity= %d\n", size, data.length));
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

}
