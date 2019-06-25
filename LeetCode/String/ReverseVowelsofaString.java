package LeetCode.String;

/**
 * 345. Reverse Vowels of a String
 * 6/23/2019
 *
 */
public class ReverseVowelsofaString {
    public String reverseVowels(String s) {
        if (s.length() == 0 || s == null)
            return s;
        char[] ch = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && vowels.indexOf(ch[start]) == -1)
                start++;
            while (start < end && vowels.indexOf(ch[end]) == -1)
                end--;
            char temp = ch[start];
            ch[start++] = ch[end];
            ch[end--] = temp;
        }
        return String.valueOf(ch);
    }
}
