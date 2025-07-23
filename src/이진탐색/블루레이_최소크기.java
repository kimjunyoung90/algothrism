package 이진탐색;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2343
 * 1, 2, 3, 4, 5, 6, 7, 8, 9
 */
public class 블루레이_최소크기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] disks = new int[n];

        int min = 0;
        int max = 0;
        //디스크의 합을 구하고 점차 합의 수를 줄여나가면서 풀이하는 방식
        //최소값 = 최대 디스크 크기
        //최대값 = 모든 디스크 크기 합

        for (int i = 0; i < n; i++) {
            disks[i] = scanner.nextInt();
            max += disks[i];
        }
        min = disks[n - 1];


        while (min <= max) {
            int mid = (max + min) / 2;
            int sum = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (sum + disks[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum = sum + disks[i];
            }

            if (sum != 0) {
                count++;
            }

            if (count > m) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(min);

    }
}
