package 그래프;

/**
 * 6/13
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/49191
 * n명의 권투선수가 권투 대회에 참여했고 각각 1번부터 n번까지 번호를 받았습니다.
 * 권투 경기는 1대1 방식으로 진행이 되고, 만약 A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이깁니다.
 * 심판은 주어진 경기 결과를 가지고 선수들의 순위를 매기려 합니다.
 * 하지만 몇몇 경기 결과를 분실하여 정확하게 순위를 매길 수 없습니다.
 *
 * 선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때 정확하게 순위를 매길 수 있는 선수의 수를 return 하도록 solution 함수를 작성해주세요.
 */
public class 순위 {
    public static void main(String[] args) {
        int 권투선수 = 5;
        int [][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        System.out.println(solution(권투선수, results));
    }

    public static int solution(int n, int[][] results) {

        int answer = 0;
        int[][] total = new int[n + 1][n + 1];

        for (int i = 0; i < results.length; i++) {
            int winner = results[i][0];
            int loser = results[i][1];

            total[winner][loser] = 1;
        }

        //기록지 바탕으로 경기 결과 추론하여 채워넣기
        //내 전적을 기준으로 상대의 전적을 채워준다.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(total[j][i] == 1) {
                    for (int k = 1; k <= n ; k++) {
                        if(total[i][k] == 1) {
                            total[j][k] = 1;
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int game = 0;
            for (int j = 1; j <= n; j++) {
                if(total[i][j] == 1 || total[j][i] == 1) game++;
            }
            if(game == (n - 1)) {
                answer++;
            }
        }
        return answer;
    }
}
