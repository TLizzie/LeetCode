package LeetCode.String;

/**
 * match 来标记s中和p匹配的起始位置
 * star来标记p中出现*的位置
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int sp = 0;
        int pp = 0;
        int star = -1;
        int match = 0;

        while (sp < s.length()) {
            if (pp < p.length() &&(p.charAt(pp) == s.charAt(sp) || p.charAt(pp) == '?' )) {
                sp++;
                pp++;
            } else if (pp < p.length() && p.charAt(pp) == '*') {
                match = sp;
                star = pp;
                pp++;
            } else if (star != -1) {
                pp = star + 1;
                match++;
                sp = match;
            } else {
                return false;
            }
        }

        while (pp < p.length() && p.charAt(pp) == '*') {
            pp++;
        }
        return pp == p.length();

    }
}
