package LeetCode.String;

/**
 * 273. Integer to English Words
 * 6/26/2019
 * 很重要 要多写几遍
 * 
 */
public class IntegertoEnglishWords {
    private final String[] less20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        int i = 0;
        String res = "";
        while (num > 0) {
            if (num % 1000 != 0) {
                res = helper(num % 1000) + thousands[i] +  " " + helper(num % 1000);
            }
            i++;
            num /= 1000;
        }
        return res.trim();
    }
    public String helper(int num) {
        if (num == 0)
            return "";
        if (num < 20) {
            return less20[num % 20] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        } else {
            return less20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}
