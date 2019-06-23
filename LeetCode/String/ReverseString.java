package LeetCode.String;

/**
 * 344. Reverse String
 * 6/22/2019
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        swap(s, start, end);
        return;
    }
    public void swap(char[] s, int a, int b) {
        while(a <= b) {
            char temp = s[a];
            s[a] = s[b];
            s[b] = temp;
            a++;
            b--;
        }
    }
}
