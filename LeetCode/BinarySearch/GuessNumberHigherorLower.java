package LeetCode.BinarySearch;

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */
/**
 * Lc 374 GuessNumberHigherorLower
 * 2019/5/30
 */
public class GuessNumberHigherorLower {
    public int guessNumber(int n) {
        int i = 1, j = n;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
}
}
