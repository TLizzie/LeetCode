package LeetCode.Graph;

/**
 * 997. Find the Town Judge
 * time: O(n)
 * space: O(1)
 *
 * graph 入度 出度
 */
public class FindtheTownJudge {
    public int findJudge(int N, int[][] trust) {

        int[] inDegree = new int[N + 1];
        int[] outDegree = new int[N + 1];

        for (int[] t : trust) {
            outDegree[t[0]]++;
            inDegree[t[1]]++;
        }

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == N - 1 && outDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
