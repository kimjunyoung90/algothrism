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
        return seperate(arr, 0, arr.length - 1);
    }

    // [left, right] 구간을 정렬하며 역전쌍 개수를 반환한다.
    private long seperate(int[] arr, int left, int right) {
        // TODO(human): 1단계 - 구간을 반으로 나눠 재귀 호출하는 부분부터 작성
        //언제까지??
        if(left >= right) {
            System.out.println(arr[left]);
            return 0;
        }

        //요소가 다섯개다
        //그럼 중간값은 3이다.
        //왼쪽은 3개
        //오른쪽은 2개
        //0, 1, 2
        //3, 4
        int mid = (left + right) / 2;
        seperate(arr, left, mid);
        seperate(arr, mid + 1, right);
        return 0;
    }

    public static void main(String[] args) {
        병합정렬_역전쌍_세기 test = new 병합정렬_역전쌍_세기();

        System.out.println(test.countInversions(new int[]{1, 1, 1, 2, 2})); // 기대값: 0
//        System.out.println(test.countInversions(new int[]{2, 1, 3, 1, 2})); // 기대값: 4
    }
}
