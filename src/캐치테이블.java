public class 캐치테이블 {

    //야간 시간 기준
    public static final int NIGHT_START = 22;
    public static final int NIGHT_END = 24;

    //주휴 오버 시간 기준
    public static final int WEEKLY_OVER_MIN_HOURS = 15;

    //수당 비율
    public static final double NIGHT_RATE = 0.5;
    public static final double OVERTIME_RATE = 0.5;
    public static final double WEEKEND_RATE = 0.5;
    public static final double WEEKLY_OVER_RATE = 0.2;

    public static final int SATURDAY = 6;
    public static final int SUNDAY = 0;

    public int solution(int[][] works, int wage) {
        //1. 일별, 기본, 야간, 주말 근무 시간 계산
        int[] dailyWorks = new int[32];

        int basicHours = 0;
        int nightHours = 0;
        int weekendHours = 0;
        int overtimeHours = 0;
        int weeklyOverHours = 0;

        for(int[] work : works) {
            int startDay = work[0];
            int startTime = work[1];
            int endDay = work[2];
            int endTime = work[3];
            for (int day = startDay; day <= endDay; day++) {

                // 엣지 케이스 : endTime 이 0인날 계산 불필요, endDay 32 계산 제외
                if(day == endDay && endTime == 0) {
                    continue;
                }

                int start = day == startDay ? startTime : 0;
                int end = day == endDay ? endTime : 24;
                int hours = end - start;

                //1-1. 일별 근무 시간(주휴 시간 계산 시 필요)
                dailyWorks[day] += hours;

                //1-2. 기본 총 근무 시간
                basicHours += hours;

                //1-3. 야간 근무 시간(22 ~ 24)
                nightHours += Math.max(0, Math.min(end, NIGHT_END) - Math.max(start, NIGHT_START));

                //1-4. 주말 근무 시간
                if(isWeekend(day)) {
                    weekendHours += hours;
                }
            }
        }

        //2. 연장 근무, 주휴 초근 시간 계산
        //2-1. 연장 근무 시간
        for (int day = 1; day <= 31; day++) {
            if (dailyWorks[day] > 8) {
                overtimeHours += (dailyWorks[day] - 8);
            }
        }

        //2-2. 주휴 초근 시간
        //주별 계산
        int weeks = 31 / 7;
        for (int week = 0; week < weeks; week++) {
            int weeklyTotal = 0;

            for (int day = week * 7 + 1; day <= week * 7 + 7; day++) {
                weeklyTotal += dailyWorks[day];
            }

            if(weeklyTotal >= WEEKLY_OVER_MIN_HOURS) {
                weeklyOverHours += weeklyTotal;
            }
        }

        // 금액 계산
        int basicPay = basicHours * wage;
        int nightPay = (int)(nightHours * wage * NIGHT_RATE);
        int weekendPay = (int)(weekendHours * wage * WEEKEND_RATE);
        int overtimePay = (int)(overtimeHours * wage * OVERTIME_RATE);
        int weeklyOverPay = (int)(weeklyOverHours * wage * WEEKLY_OVER_RATE);

        return basicPay + nightPay + weekendPay + overtimePay + weeklyOverPay;
    }

    private static boolean isWeekend(int day) {
        int dayOfWeek = day % 7;
        return dayOfWeek == SATURDAY || dayOfWeek == SUNDAY;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcdef");
        sb.deleteCharAt(3);
        System.out.println(sb);
    }
}
