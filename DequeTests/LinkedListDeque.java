public class LinkedListDeque<T> implements Deque<T> {

    private class ListNode {
        private T item;
        private ListNode next;
        private ListNode prev;

        public ListNode(T i, ListNode n, ListNode p) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private ListNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new ListNode(null, sentinel, sentinel);
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        ListNode newNode = new ListNode(x, sentinel.next, sentinel);
        if (size == 0) {
            sentinel.next = newNode;
            sentinel.prev = newNode;
        } else {
            ListNode oldNode = sentinel.next;
            oldNode.prev = newNode;
            sentinel.next = newNode;
        }
        size += 1;

    }

    @Override
    public void addLast(T x) {
        ListNode newNode = new ListNode(x, sentinel, sentinel.prev);
        if (size == 0) {
            sentinel.next = newNode;
            sentinel.prev = newNode;
        } else {
            ListNode oldNode = sentinel.prev;
            oldNode.next = newNode;
            sentinel.prev = newNode;
        }
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int i = 0;
        ListNode temp = new ListNode(null, sentinel.next, sentinel.prev);
        while (i < size) {
            System.out.print(temp.next.item + " ");
            temp = temp.next;
            i += 1;
        }
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            T outputItem = sentinel.next.item;
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
            size = 0;
            return outputItem;

        } else {
            T outputItem = sentinel.next.item;
            ListNode oldNode = sentinel.next;
            ListNode newNode = sentinel.next.next;
            sentinel.next = newNode;
            newNode.prev = sentinel;
            size -= 1;
            return outputItem;
        }
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            T outputItem = sentinel.prev.item;
            sentinel.prev = sentinel;
            sentinel.next = sentinel;
            size = 0;
            return outputItem;
        } else {
            T outputItem = sentinel.prev.item;
            ListNode oldNode = sentinel.prev;
            ListNode newNode = sentinel.prev.prev;
            sentinel.prev = newNode;
            newNode.next = sentinel;
            size -= 1;
            return outputItem;
        }
    }

    @Override
    public T get(int index) {
        int i = 0;
        ListNode outputItem = sentinel.next;
        while (i < index) {
            outputItem = outputItem.next;
            i += 1;
        }
        return outputItem.item;
    }

    public T getRecursive(int index) {
        ListNode temp = sentinel;
        return getRecursiveHelper(index, temp).item;
    }

    private ListNode getRecursiveHelper(int i, ListNode x) {
        if (i == 0) {
            return x.next;
        } else {
            return getRecursiveHelper(i - 1, x.next);
        }
    }

}
