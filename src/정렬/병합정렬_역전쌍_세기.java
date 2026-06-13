package 정렬;

/**
 * 병합정렬_역전쌍_세기 (Merge Sort: Counting Inversions)
 *
 * 인접한 원소를 교환(swap)하여 배열을 오름차순으로 정렬할 때 필요한 교환 횟수,
 * 즉 i < j 이면서 arr[i] > arr[j] 인 쌍(역전쌍)의 총 개수를 구하라.
 *
 * 제약조건:
 * - 1 <= n <= 10^5
 * - 1 <= arr[i] <= 10^9
 *
 * @link https://www.hackerrank.com/challenges/ctci-merge-sort/problem
 */
public class 병합정렬_역전쌍_세기 {
    public long countInversions(int[] arr) {
        // TODO(human): 구현하세요.
        // 목표 : 배열을 오름차순으로 정렬할 때 필요한 교환 횟수
        // 인접한 원소를 교환
        // 횟수 +
        // 근데, 인접한 원소만 swap해서 정렬을 하려면 한번 순회해선 정렬이 되진 않을텐데.
        // 1. arr의 요소를 순회하며 인접한 원소 비교
        int answer = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                int cur = arr[j];
                int next = arr[j + 1];
                //오름차순 = 작은 값이 선행
                if(cur > next) {
                    int temp = cur;
                    arr[j] = next;
                    arr[j + 1] = temp;
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        병합정렬_역전쌍_세기 test = new 병합정렬_역전쌍_세기();

        System.out.println(test.countInversions(new int[]{1, 1, 1, 2, 2})); // 기대값: 0
        System.out.println(test.countInversions(new int[]{2, 1, 3, 1, 2})); // 기대값: 4
    }
}
