/**
 * 나눌_수_있는_부분_수열
 *
 * 양의 정수 수열에서, 연속하는 부분 수열의 합이 d로 나누어 떨어지는 것의 개수를 구한다.
 *
 * 제약조건:
 * - 1 ≤ d ≤ 1,000,000
 * - 1 ≤ n ≤ 50,000
 * - 1 ≤ 각 원소 ≤ 1,000,000,000
 *
 * @link https://takjoon.takijk.xyz/problems/27738
 */
public class 나눌_수_있는_부분_수열 {
    public long solve(int d, int[] arr) {
        // 부분 수열의 합이 나누어 떨어지는
        //2, 1, 2, 1, 1, 2, 1, 2
        //2, 3, 5, 6, 7, 9, 10, 12
        //구간별 합을 구하고
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = arr[i] + sum[i - 1];
        }
        //부분 수열 조합을 구하고
        //0 ~ 1, 0 ~ 2 ... 0 ~ N
        //1 ~ 2, 1 ~ 3 ... 1 ~ N
        //2 ~ 3, 2 ~ 4 ... 2 ~ N

        int answer = 0;
        for (int i = 0; i < sum.length - 1; i++) {
            for (int j = i + 1; j < sum.length; j++) {
                int gap = sum[j] - sum[i] + arr[i];
                if(gap % d == 0) answer++;
            }
        }
        //조건에 맞는지 체크한다.
        return answer;
    }

    public static void main(String[] args) {
        나눌_수_있는_부분_수열 test = new 나눌_수_있는_부분_수열();

        // 예제 1: 기대값 0
        System.out.println(test.solve(7, new int[]{1, 2, 3}));
        // 예제 2: 기대값 6
        System.out.println(test.solve(4, new int[]{2, 1, 2, 1, 1, 2, 1, 2}));
    }
}
