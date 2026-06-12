package 정렬;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 부정거래_알림 (Fraudulent Activity Notifications)
 *
 * 은행은 고객의 하루 지출이 직전 d일간 지출의 중앙값(median)의 2배 이상이면
 * 부정거래 알림을 보낸다. 알림을 보내려면 최소 d일치의 사전 거래 데이터가 필요하다.
 * 주어진 일별 지출 내역과 조회 기간 d로 보내진 알림의 총 개수를 구하라.
 *
 * 제약조건:
 * - n, d ≤ 200,000
 * - 0 ≤ expenditure[i] ≤ 200,000
 *
 * @link https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
 */
public class 부정거래_알림 {

    // ── counting sort 버전 (작업 중) ──────────────────────────────
    private static final int MAX_VALUE = 200_000;

    public int activityNotifications(int[] expenditure, int d) {
        int[] count = new int[MAX_VALUE + 1];

        for (int i = 0; i < d; i++) {
            count[expenditure[i]]++;
        }

        int answer = 0;
        for (int i = d; i < expenditure.length; i++) {
            if (expenditure[i] >= twiceMedian(count, d)) {
                answer++;
            }
            count[expenditure[i - d]]--;
            count[expenditure[i]]++;
        }

        return answer;
    }

    private int twiceMedian(int[] count, int d) {
        int median = 0;
		int accum = 0;
		if(d % 2 == 1) {
			for (int i = 0; i < count.length; i++) {
                accum += count[i];
                if(accum >= d/2 + 1) {
                    median = i;
                    break;
                }
            }
            median *= 2;
		} else {
			boolean findFirst = false;
            for (int i = 0; i < count.length; i++) {
                accum += count[i];
                if(!findFirst && accum >= d/2) {
                    median += i;
                    findFirst = true;
                }
                if(accum >= d/2 + 1) {
                    median += i;
                    break;
                }
            }
		}

		return median;
    }
    // ──────────────────────────────────────────────────────────────

    public static void main(String[] args) {
        부정거래_알림 test = new 부정거래_알림();

        // 샘플 0
        int result0 = test.activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}, 5);
        System.out.println(result0); // 기대값: 2

        // 샘플 1
        int result1 = test.activityNotifications(new int[]{1, 2, 3, 4, 4}, 4);
        System.out.println(result1); // 기대값: 0
    }
}
