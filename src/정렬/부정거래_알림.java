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
    public int activityNotifications(int[] expenditure, int d) {
        // TODO(human): 구현하세요.
        //고객의 하루 지출이 직전 d일간 지출의 중앙 값 2배 이상이면 부정거래 알림 발송
        //d = 거래 데이터 검증해야하는 기간
        //expenditure = 일별 지출 내역
        //중앙 값 = 데이터를 크기 순으로 정렬했을 때 한 가운데에 있는 값
        //1. d일간 지출 내역을 확인할 수 있는 날짜 확인
        //ex) expenditure = 9, d = 5 면 6일부터 부정거래 확인 가능
        int minDay = d + 1;//minday = 6;

        //2. 검증 가능한 최소 날짜 부터 검증
        int answer = 0;
        for (int i = minDay; i < expenditure.length; i++) {
            //minDay = 6일째 값 = day - 1
            int target = expenditure[i - 1];
            if(target >= mid(expenditure, i - 1, d) * 2) {
                answer++;
            }
        }

        return answer;
    }

    private int mid (int[] expenditure, int 부정거래의심, int d) {
        //부정거래의심 = 5
        //1 ~ 5; = to - from + 1
        //5 -5 = 0 = 5 ~ 0; = 0, 1, 2, 3, 4
        int[] days = new int[d];
        int daysIdx = 0;
        for (int i = 부정거래의심 - d; i < 부정거래의심; i++) {
            days[daysIdx++] = expenditure[i];
        }
        Arrays.sort(days);
        return days[d/2];
    }

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
