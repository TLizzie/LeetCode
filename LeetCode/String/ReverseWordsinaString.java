package LeetCode.String;

/**
 * 151. Reverse Words in a String
 * 6/22/2019
 *
 */
public class ReverseWordsinaString {

    //熟练运用java 内置函数
    public String reverseWords(String s) {
        if (s.length() == 0 || s == null) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        String[] words = s.trim().split("\\s+");
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i] + " ");
        }
        return sb.toString().trim();
    }

    public String reverseWords2(String s) {
        if (s.length() == 0 || s == null)
            return s;
        char[] ch = s.toCharArray();
        reverse(ch, 0, s.length() - 1);
        reverseWord(ch, s.length());
        return cleanSpace(ch, s.length());
    }

    private void reverse(char[] s, int a, int b) {
        while(a < b) {
            char temp = s[a];
            s[a++] = s[b];
            s[b--] = temp;
        }
    }
    private void reverseWord(char[] s, int len) {
        int i = 0;
        int j = 0;
        while(i < len) {
            while (i < j || i < len && s[i] == ' ') i++; // pointer to jump spaces
            while (j < i || j < len && s[j] != ' ') j++; // pointer to jump non-spaces
            reverse(s, i , j - 1);
        }
    }
    private String cleanSpace(char[] s, int len) {
        int i = 0;
        int j = 0;
        while (j < len) {
            while (j < len && s[j] == ' ') j++;
            while (j < len && s[j] != ' ') s[i++] = s[j++];
            while (j < len && s[j] == ' ') j++;
            if (j < len) s[i++] = ' ';
        }
        return String.valueOf(s).substring(0, i);
    }
}
