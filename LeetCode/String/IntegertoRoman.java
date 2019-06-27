package LeetCode.String;

/**
 * 12. Integer to Roman
 * 6.26.2019
 * 思路:
 * 换算数值，然后输出String
 */
public class IntegertoRoman {
    public String intToRoman(int num) {
    int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < value.length; i++) {
        while (num >= value[i]) {
            num -= value[i];
            sb.append(roman[i]);
        }
    }
    return sb.toString();
    }


}
