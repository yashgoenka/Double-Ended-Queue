public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int dequeStart;
    private int dequeEnd;

    private int RFACTOR = 2;

    /** Creates an empty deque. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        dequeStart = 0;
        dequeEnd = 0;
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        if (dequeStart <= dequeEnd) {
            System.arraycopy(items, dequeStart, a, 0, size);
        } else {
            System.arraycopy(items, dequeStart, a, 0, items.length - dequeStart);
            System.arraycopy(items, 0, a, items.length - dequeStart, dequeEnd + 1);
        }
        items = a;
        dequeStart = 0;
        dequeEnd = size - 1;
    }

    /** Reduces length of array if less than 25% of it is used */
    private void removeRedundancy() {
        if (items.length >= 16) {
            double usageRatio = (double) size / items.length;
            while (!(usageRatio > 0.25)) {
                resize(items.length / 2);
                usageRatio = size / items.length;
            }
        }
    }

    /*
    public Glorp deleteBack () {
        Glorp returnItem = getBack();
        items[size - 1] = null;
        size -= 1;
        return resturnItem;
    }
    */

    /** Inserts X into the front of the deque. */
    public void addFirst(T x) {
        if (size == 0) {
            items[0] = x;
            dequeStart = 0;
            dequeEnd = 0;
        } else {
            if (size == items.length) {
                resize(size * RFACTOR);
            }
            if (dequeStart == 0) {
                items[items.length - 1] = x;
                dequeStart = items.length - 1;
            } else {
                items[dequeStart - 1] = x;
                dequeStart = dequeStart - 1;
            }
        }
        size += 1;
    }

    /** Inserts X into the back of the deque. */
    public void addLast(T x) {
        if (size == 0) {
            items[0] = x;
            dequeStart = 0;
            dequeEnd = 0;
        } else {
            if (size == items.length) {
                resize(size * RFACTOR);
            }
            if (dequeEnd == (items.length - 1)) {
                items[0] = x;
                dequeEnd = 0;
            } else {
                items[dequeEnd + 1] = x;
                dequeEnd += 1;
            }
        }
        size = size + 1;
    }

    /** Returns true if deque is empty, false otherwise */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first
     * to last, separated by a space */
    public void printDeque() {
        if (dequeEnd >= dequeStart) {
            int i = dequeStart;
            while (i <= dequeEnd) {
                System.out.print(items[i] + " ");
                i += 1;
            }
        } else {
            int i = dequeStart;
            while (i < items.length) {
                System.out.print(items[i] + " ");
                i += 1;
            }
            int j = 0;
            while (j <= dequeEnd)  {
                System.out.print(items[j] + " ");
                j += 1;
            }
        }
    }

    /** Deletes item from front of the deque and
     * returns deleted item. */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T x = items[dequeStart];
        items[dequeStart] = null;
        size -= 1;
        if (size == 0) {
            dequeStart = 0;
            dequeEnd = 0;
        }  else if (dequeStart == (items.length - 1)) {
            dequeStart = 0;
        } else {
            dequeStart += 1;
        }
        removeRedundancy();
        return x;
    }

    /** Deletes item from back of the deque and
     * returns deleted item. */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T x = getLast();
        items[dequeEnd] = null;
        size = size - 1;
        if (size == 0) {
            dequeEnd = 0;
            dequeStart = 0;
        } else if (dequeEnd == 0) {
            dequeEnd = items.length - 1;
        } else {
            dequeEnd -= 1;
        }
        removeRedundancy();
        return x;
    }

    /** Returns the item from the back of the deque. */
    private T getLast() {
        return items[dequeEnd];
    }

    /** Gets the ith item in the deque (0 is the front). */
    public T get(int i) {
        if (dequeStart <= dequeEnd) {
            return items[i + dequeStart];
        } else {
            if (i <= (items.length - 1) - dequeStart) {
                return items[i + dequeStart];
            } else {
                return items[i - ((items.length) - dequeStart)];
            }

        }
    }
}
