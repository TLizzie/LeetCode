package foundation.array;

/**
 * overload functions
 */
public class function {
    public static void test1() {
        System.out.println("1");
    }

    public static void test2(int a) {

    }

    public static int test3() {
        System.out.println("1");
        return 0;
    }

    public static int test4(int a) {
        System.out.println("1");
        return 0;
    }



    public static void swap(int a, int b) {
        int swap = a;
        a = b;
        b = swap;
        System.out.println("a = " + a + "b = " + b);
    }

    public static void overload(int a) {
        System.out.println("1");
    }

    public static void overload(int a, int b) {
        System.out.println("1");
    }

    public static void overload(int... a) {
        System.out.println("1");
    }

    public static void main(String[] args) {
        swap(2,3);
    }
}
