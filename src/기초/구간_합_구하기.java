package 기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 누적 합 구하기
 */
public class 구간_합_구하기 {
    public static void main(String[] args) throws IOException {
        // 입력 속도 빠름
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: N M
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2번째 줄 N개의 숫자
        int[] numbers = new int[N + 1];
        int[] sums = new int[N + 1];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            sum += numbers[i];
            sums[i] = sum;
        }

        //M 줄 : i, j 구간
        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(sums[j] - sums[i - 1]);
        }
        
    }
}
