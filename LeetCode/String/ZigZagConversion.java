package LeetCode.String;

/**
 * 6. ZigZag Conversion
 * 6/25/2019
 * 数学规律题
 * 关于java的基本操作要熟悉
 * 懵逼
 *
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows <= 1)
            return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < s.length(); i++) {
            sb[i] = new StringBuilder("");
        }
        for (int i = 0; i < s.length(); i++) {
            int index = i % (2 * numRows - 2);
            index = index < numRows ? index : (2 * numRows - 2 - index);
            sb[index].append(s.charAt(i));
        }
        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
