package CoTe;

public class Solution {


    public int solution(int[][] board) {

        int safecount=0;
        int n = board.length;
        boolean[][] dangerous = new boolean[n][n];//위험지역 표시

        //마킹
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    for (int x = -1; x <= 1; x++) {
                        for (int y = -1; y <= 1; y++) {
                            int dx = x + i;
                            int dy = y + j;
                            if (dx >= 0 && dy >= 0 && dx < n && dy < n) {
                               dangerous[dx][dy] = true;
                            }
                        }
                    }
                }
            }
        }

        //안전 지역의 개수
        int safe = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] ==0&& !dangerous[i][j]){
                    safecount++;
                }
            }
        }
    return safecount;
    }


    public static void main(String[] args) {


        Solution solution = new Solution();

        int[][] board1 = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}};
        System.out.println(solution.solution(board1));

    }

}
