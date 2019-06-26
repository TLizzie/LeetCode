package LeetCode.String;

/**
 * 171. Excel Sheet Column Number
 * 6/25/2019
 */

public class ExcelSheetColumnNumber {
    public int convertToNumber(String s) {
        int res  = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + s.charAt(i) + 1 - 'A';
        }
        return res;
    }
}
