import java.util.Arrays;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/389479
 */
public class 서버_증설_횟수 {
    public int solution(int[] players, int m, int k) {
        int[] required = new int[players.length];
//        int[]

        for(int i = 0; i < players.length; i++) {
            required[i] = (int) Math.ceil(players[i] / m);
        }

        System.out.println(Arrays.toString(required));

        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        int[] players = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int m = 3;
        int k = 5;
        System.out.println(new 서버_증설_횟수().solution(players, m, k));
    }
}
