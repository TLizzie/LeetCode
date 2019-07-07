package LeetCode.Math;

import java.util.List;
import java.util.ArrayList;
/**
 * 386. Lexicographical Numbers
 * 7/6/2019
 * time : O(n)
 * space: O(n)
 */
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        int cur = 1;
        for (int i = 1; i <= n; i++) {
            list.add(cur);
            if (cur * 10 <= n) {
                cur *= 10;
            } else if (cur % 10 != 9 && cur + 1 <= n) {             //499 5 50
                cur++;
            } else {
                while ((cur / 10) % 10 == 9) {
                    cur /= 10;
                }
                cur = cur / 10 + 1;
            }
        }
        return list;
    }
}
