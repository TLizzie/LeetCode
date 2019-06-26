package LeetCode.String;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. Largest Number
 * 6/25/2019
 * 重写函数
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums.length == 0 || nums == null)
            return "";
        String[] res = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(res, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);
            }
        });
        if (res[0].charAt(0) == '0')
            return "0";
        String result = "";
        for (String s : res) {
            result += String.valueOf(s);
        }
        return result;
    }
}
