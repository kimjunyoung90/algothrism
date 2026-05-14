package 기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이차방정식
 * <p>
 * x² + 2Ax + B = 0의 두 계수 A, B가 주어진다.
 * 방정식의 근들을 공백으로 분리해 오름차순으로 출력한다.
 * 중근일 경우 하나만 출력한다.
 * <p>
 * 제약조건:
 * - A, B는 정수
 * - -1000 ≤ A, B ≤ 1000
 * - 근은 항상 정수
 *
 * @link https://takjoon.takijk.xyz/problems/8589
 */
public class 이차방정식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // TODO(human): 구현하세요.

        // 예제 1: A=2, B=3 → -3 -1
        // 예제 2: A=1, B=-8 → -4 2
        // 예제 3: A=1, B=1 → -1
//        x * x + 4x + 3 = 0;
//
//        (x + 2A/2^-1)^2 + 2Ax + 2A/2 = -B + 2A/2


    }
}
