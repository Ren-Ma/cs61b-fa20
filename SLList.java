public class SLList {
    
    public static class IntNode {
         public int item;
         public IntNode next;

         public IntNode(int i, IntNode n) {
             item = i;
             next = n;
         }
    }

    private IntNode first;
    private int size;

    public SLList() {
        first = null;
        size = 0;
    }

    public SLList(int x) {
        first = new IntNode(x, null);
        size = 1;
    } 

    public void addFirst(int x) {
        first = new IntNode(x, first);
        size += 1;
    }

    public int getFirst() {
        return first.item;
    }

    public void addLast(int x) {
        size += 1;
        IntNode p = first;

        if (first == null) {
            first = new IntNode(x, null);
            return;
        }
        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        } 
        p.next = new IntNode(x, null);
    }

    private static int intNodeSize(IntNode p){
        if (p.next == null){
            return 1;
        } 
        return 1 + intNodeSize(p.next);
    }

    public int size() {
        
        /* iterative solution */
        // IntNode p = first;
        // int totalSize = 0;
        // while (p != null) {
        //     p = p.next;
        //     totalSize += 1;
        // } return totalSize;

        /* recursive solution */
        // return intNodeSize(first);
        return size;
    }

    public static void main(String[] args) {
        // SLList L = new SLList(15);
        SLList L = new SLList();
        // L.addFirst(10);
        L.addLast(24);
        System.out.println(L.getFirst());
    }
}

