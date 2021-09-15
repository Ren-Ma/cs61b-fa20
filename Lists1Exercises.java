public class Lists1Exercises {
    /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static IntList incrList(IntList L, int x) {
        /* Your code here. */
        if (L.size() == 1){
            IntList Q = new IntList(L.first + x, null);
            return Q;
        } return new IntList(L.first + x, incrList(L.rest , x));
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
        IntList Q = L;
        for (int i = 0; i < L.size(); i += 1){
            L.first += x;
            L = L.rest;
        }
        return Q;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);

        System.out.println(L.size());
        System.out.println(L.iterativeSize());

        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
        System.out.println(L.get(1));
        IntList newList1 = incrList(L, 3);
        System.out.println(newList1);
        IntList newList2 = dincrList(L, 3);
        System.out.println(newList2);        
    }
}