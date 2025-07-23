package 기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N x N 개의 수가 N x N 크기의 표에 채워져 있다.
 * 표 안의 수 중(X1
 */
public class 구간_합_구하기2 {
    public static void main(String[] args) throws IOException {
        //1번째 줄에 표의 크기 N, 합을 구해야 하는 횟수 M
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        
        int[][] A = new int[N + 1][N + 1];
        for (int y = 1; y < N + 1; y++) {
            st = new StringTokenizer(br.readLine());

            for (int x = 1; x < N + 1; x++) {
                int value = Integer.parseInt(st.nextToken());
                A[y][x] = value;
            }
        }

        //누적합 구하기
        int[][] S = new int[N + 1][N + 1];
        for (int x = 1; x < N + 1; x++) {
            for (int y = 1; y < N + 1; y++) {
                S[y][x] = A[y][x] + S[y][x - 1] + S[y - 1][x] - S[y - 1][x - 1];
            }
        }

        //지정한 범위 누적합 구하기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            //(x1, y1) ~ (x2, y2) 까지의 합
            int result = S[y2][x2] - S[y2][x1 -1] - S[y1 - 1][x2] + S[y1 - 1][x1 - 1];
            System.out.println(result);
        }
    }
}
