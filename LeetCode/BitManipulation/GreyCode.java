package LeetCode.BitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * 89 Grey code
 * 7/2/2019
 * G(i) = i ^ (i / 2)
 * time: O( 1 >> n)
 * space: O(1)
 */
public class GreyCode {
    public List<Integer> greyCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++) {
            res.add(i ^ (i / 2));
        }
        return res;
    }

}
