/* Implement fib which takes in an integer n and returns the nth Fibonacci number.
Fibonacci sequence = {0,1,1,2,3,5,8,13,21,34, ...}
f(n) = f(n-1) + f(n-2) */

// 1. Classical recursion solution
public class ClassNameHere {
    // define the method _fib2_ for a Fibonacci number
    public static int fib(int n) {
        // base case
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
    // call the _fib2_ method.
    public static void main(String[] args) {
       System.out.println(fib(4));
    }
 }

//  2. Smarter recursion solution
public class ClassNameHere {
    // define the method _fib2_ for a Fibonacci number
    public static int fib2(int n, int k, int f0, int f1) {
       if (n == k) {
          return f0;
       } else {
        /* here we increment k from 0 to n by 1,
        and update f(k) and f(k+1)*/
          return fib2(n, k + 1, f1, f0 + f1);
       }
    }
    // call the _fib2_ method.
    public static void main(String[] args) {
       System.out.println(fib2(4, 0, 0, 1));
    }
 }

//  3. Interative solution
public class ClassNameHere {
    // define the method _fib2_ for a Fibonacci number
    public static int fib2_while(int n) {
        int k = 0;
        int f0 = 0;
        int f1 = 1;
        while (n != k) {
            // update f(k) and f(k+1)
            temp = f0;
            f0 = f1;
            f1 = temp + f1;
            k += 1;
        }   return f0;
    } 
    // call the _fib2_ method.
    public static void main(String[] args) {
    System.out.println(fib2_while(4));
    }
}