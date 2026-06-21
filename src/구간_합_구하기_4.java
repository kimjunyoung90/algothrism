/**
 * 구간_합_구하기_4 (백준 11659)
 *
 * 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지의 합을 M번 구한다.
 *
 * 제약조건:
 * - 수는 1,000보다 작거나 같은 자연수
 * - M번의 구간 합 질의를 빠르게 처리해야 한다
 *
 * @link https://takjoon.takijk.xyz/problems/1791
 */
public class 구간_합_구하기_4 {
    public int[] solve(int[] nums, int[][] queries) {
        // TODO(human): 구현하세요.
        //누적합 구한다음에 빼면 되겠구나.
        //5, 4, 3, 2, 1
        //5, 9, 12, 14, 15
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] += nums[i] + sum[i];
        }

        int[] answer = new int[queries.length];
        int idx = 0;
        for (int[] query : queries) {
            int from = query[0];
            int to = query[1];
            //from 포함
            answer[idx++] = sum[to] - sum[from - 1];
        }
        return answer;
    }

    public static void main(String[] args) {
        구간_합_구하기_4 test = new 구간_합_구하기_4();

        int[] nums = {5, 4, 3, 2, 1};
        int[][] queries = {
                {1, 3},
                {2, 4},
                {5, 5}
        };

        int[] result = test.solve(nums, queries);
        for (int r : result) {
            System.out.println(r); // 기대값: 12, 9, 1
        }
    }
}
