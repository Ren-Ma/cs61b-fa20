public class ClassNameHere {
    public static int max(int[] m) {
       int max_num = m[0];
       int i = 0;
       while (i < m.length-1) {
          if (m[i] >= max_num) {
             max_num = m[i];
          } 
          i = i+1;
       } 
       return max_num;
    }
 
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};  
       System.out.println(max(numbers));
    }
 }