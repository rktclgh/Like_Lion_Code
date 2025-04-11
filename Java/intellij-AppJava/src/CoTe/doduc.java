package CoTe;

public class doduc {




    public static int solution(int[][] info, int n, int m) {
        int itemCount = info.length;
        int INF = 999_999_999;

        // dp[i][j] = i번째 아이템까지 고려, B의 흔적이 j일 때 A의 최소 흔적
        int[][] dp = new int[itemCount + 1][m];

        // 초기값 설정
        for (int i = 0; i <= itemCount; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = INF;
            }
        }
        dp[0][0] = 0; // 아무것도 훔치지 않은 초기 상태

        for (int i = 0; i < itemCount; i++) {
            int aTrace = info[i][0];
            int bTrace = info[i][1];

            for (int b = 0; b < m; b++) {
                if (dp[i][b] == INF) continue;

                // A가 i번째 아이템을 훔칠 경우
                int aNext = dp[i][b] + aTrace;
                if (aNext < n) {
                    dp[i + 1][b] = Math.min(dp[i + 1][b], aNext);
                }

                // B가 i번째 아이템을 훔칠 경우
                int bNext = b + bTrace;
                if (bNext < m) {
                    dp[i + 1][bNext] = Math.min(dp[i + 1][bNext], dp[i][b]);
                }
            }
        }

        // 마지막 줄에서 A의 흔적 최소값 찾기
        int minA = INF;
        for (int b = 0; b < m; b++) {
            minA = Math.min(minA, dp[itemCount][b]);
        }

        return (minA == INF) ? -1 : minA;
    }

    // 테스트
    public static void main(String[] args) {
        int[][] test1 = {{1, 2}, {2, 3}, {2, 1}};
        System.out.println(solution(test1, 4, 4)); // 2

        int[][] test2 = {{1, 2}, {2, 3}, {2, 1}};
        System.out.println(solution(test2, 1, 7)); // 0

        int[][] test3 = {{3, 3}, {3, 3}};
        System.out.println(solution(test3, 7, 1)); // 6

        int[][] test4 = {{3, 3}, {3, 3}};
        System.out.println(solution(test4, 6, 1)); // -1
    }
}
