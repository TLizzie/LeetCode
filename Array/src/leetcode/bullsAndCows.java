package leetcode;

/**
 * Leetcode 299 Bulls and cows
 * 创建了一个长度为10的int数组，因为每个位置的数字范围就是0——9，数组的index就对应0——9，而index对应的元素值表示secret中该index出现的次数。
 * 如果secret出现一次某个数字，该位置就自增1，如果此时该位置小于0，就说明这个数字在guess出现过，因此cows就自增1；
 * guess的处理和secret类似，区别就是index对应元素需要自减。
 *
 * time: O(n)
 * space: O(1)
 */
public class bullsAndCows {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cows = 0;
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            }   else {
                if (count[secret.charAt(i) - '0']++ < 0 ) cows++;
                if (count[guess.charAt(i) - '0']-- > 0) cows++;
            }
        }
        return bull + "A" + cows + "B";
    }
}
