public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);

        linkedList.addFirst(0);

        System.out.println(linkedList.removeFirst());

        // System.out.println(linkedList.toString());
        System.out.println("是否为空：" + linkedList.isEmpty());

    }
}
