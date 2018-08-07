
public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<String> x=new ArrayDeque<String>();

        // System.out.println(x.get(0));
        // System.out.println(x.getSize());
        // // // System.out.println(x.get(7));
        // // // System.out.println(x.removeFirst());
        // // // System.out.println(x.get(7));
        // // // System.out.println(x.get(7));

        ArrayDeque<Integer> y =new ArrayDeque<Integer>();

        /** d005) AD-basic: Random addLast/removeFirst/isEmpty tests. (0.0/1.176) */
        y.addLast(0);
        y.addLast(1);
        y.addLast(2);
        y.removeFirst();
        y.addLast(4);
        y.addLast(5);
        y.addLast(6);
        y.addLast(7);
        y.addLast(8);
        y.addLast(9);

        /** d006) AD-basic: Random add/remove/isEmpty/size tests. (0.0/1.176) */
        y.isEmpty();
        y.size();
        y.addFirst(2);
        y.isEmpty();
        y.isEmpty();
        y.addFirst(5);
        y.removeLast();
        y.addLast(7);

        /** d011) AD-basic: get. (0.0/1.176) */
        y.addLast(0);
        y.removeFirst();
        y.addFirst(2);
        y.removeLast();
        y.addLast(4);
        y.addFirst(5);
        y.get(1);
        y.removeLast();
        y.get(0);
        y.addLast(9);

    }
}
