package 이진탐색;

/**
 * 데이터가 정렬된 상태에서 원하는 값을 찾는 알고리즘
 * 데이터의 중앙값과 찾고자 하는 값을 비교해 데이터의 크기를 절반으로 줄이면서 대상을 찾음
 * 오름차순으로 정렬된 데이터에서 하위 작업 반복
 * 1. 현재 데이터의 중앙값 선택
 * 2. 중앙값 > 타깃데이터 중앙값 기준 왼쪽 데이터 선택
 * 3. 중앙값 < 타깃데이터 중앙값 기준 오른쪽 데이터 선택
 * 4. 중앙값 == 타깃데이터 탐색 종료
 * N개의 데이터에서 log(N)번의 연산으로 원하는 데이터의 위치를 찾을 수 있음
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * N개의 정수가 주어질 때 X라는 정수가 존재하는지 확인하는 프로그램
 */
public class 원하는_정수_찾기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            boolean find = false;
            int target = scanner.nextInt();

            //이진탐색
            int start = 0;
            int end = arr.length - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                if (arr[mid] > target) {
                    end = mid - 1;
                } else if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    find = true;
                    break;
                }
            }
            if (find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
