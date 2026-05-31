import java.util.TreeSet;

/*
 * [문제 2] 거듭제곱 수열 (완전 거듭제곱수)
 *
 * 완전 거듭제곱수(a^b, b >= 2 꼴로 표현되는 수)를 작은 순서대로
 * 나열한 수열에서 n번째 값을 반환한다. (수열에 1 포함, n은 1부터)
 *
 * 수열: 1, 4, 8, 9, 16, 25, 27, 32, 36, 49, ...
 *   1=1^2, 4=2^2, 8=2^3, 9=3^2, 16=2^4, 25=5^2, 27=3^3, ...
 *
 * --- 핵심 아이디어 ---
 * "어떤 수가 거듭제곱수인지 판별"하며 1씩 올라가는 방식은 느리다.
 * 대신 거듭제곱수를 직접 "생성"한다.
 *   밑(base) 2부터, 지수 2 이상으로 base^2, base^3, ... 를 만들어 담는다.
 *
 * 중복 제거가 반드시 필요하다.
 *   한 수가 여러 거듭제곱 표현을 가질 수 있다.
 *   예) 64 = 8^2 = 4^3 = 2^6  -> 세 번 생성되지만 수열에선 1개
 *       16 = 4^2 = 2^4
 *   TreeSet을 쓰면 중복 제거 + 자동 정렬이 한 번에 해결된다.
 *
 * --- 상한(LIMIT) 설정 ---
 * N 이하 완전거듭제곱수 개수는 대략 sqrt(N)개 (제곱수가 대부분).
 * n개를 모으려면 N이 약 n^2 이면 충분하다.
 *   -> LIMIT = (long) n * n
 *   주의: int * int 는 오버플로(최대 약 21억)가 나므로
 *         반드시 (long)으로 캐스팅 후 곱한다.
 *
 * --- 반환 타입 ---
 * n=1,000,000 이면 답이 979846576384 (약 9.8 * 10^11)로
 * int 범위를 한참 넘는다. 반환 타입은 반드시 long.
 *
 * 시간복잡도: 생성 + TreeSet 삽입. LIMIT를 n^2로 조였기에
 *             10초 제한 안에 충분히 들어온다.
 */
public class PowerSequence {

    public long solution(int n) {
        long LIMIT = (long) n * n; // 오버플로 방지: (long) 캐스팅 후 곱셈

        TreeSet<Long> set = new TreeSet<>(); // 중복 제거 + 자동 정렬
        set.add(1L);                         // 1 포함 (1 = 1^2)

        for (int i = 2; (long) i * i <= LIMIT; i++) {
            long value = (long) i * i;
            while (value <= LIMIT) {
                set.add(value);
                value *= i;
            }
        }

        long count = 0;
        for (long v : set) {
            count++;
            if(count == n) {
                return v;
            }
        }
        return -1; // 상한이 충분하다는 전제하에 도달하지 않음
    }

    // 간단한 검증용
    public static void main(String[] args) {
        PowerSequence s = new PowerSequence();
        System.out.println(s.solution(1));       // 1
        System.out.println(s.solution(2));       // 4
        System.out.println(s.solution(3));       // 8
        System.out.println(s.solution(4));       // 9
        System.out.println(s.solution(1000000)); // 979846576384
    }
}
