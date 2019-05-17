package Array;

import java.util.Arrays;

public class Array {
    public static void array() {
        int[] arr = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(arr));
        arr[1] = 3;
        System.out.println(Arrays.toString(arr));

        int[][] ar = new int[][]{
            {1,2,3},{1,2,3}};
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[0].length; j++) {
                System.out.println(ar[0][j]);
            }
        }

    }

    public static void main(String[] args) {
        array();
    }
}
