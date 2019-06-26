package LeetCode.String;

/**
 * 面试还蛮常考
 * 168. Excel Sheet Column Title
 * 6/25/2019
 * time: O(n) / O(1)
 * space: O(n)
 */

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            n--;                //为了A能输出 因此要先-1
            res.append((char)('A' + n % 26));
            n /= 26;
        }
        return res.reverse().toString();
    }
}
