package pratice;

import java.util.*;

public class StreamPractice {

    // 학생 클래스
    static class Student {
        private String name;
        private int age;
        private String major;
        private double gpa;
        private List<String> courses;

        public Student(String name, int age, String major, double gpa, List<String> courses) {
            this.name = name;
            this.age = age;
            this.major = major;
            this.gpa = gpa;
            this.courses = courses;
        }

        public String getName() { return name; }
        public int getAge() { return age; }
        public String getMajor() { return major; }
        public double getGpa() { return gpa; }
        public List<String> getCourses() { return courses; }

        @Override
        public String toString() {
            return String.format("%s(age=%d, major=%s, gpa=%.1f)", name, age, major, gpa);
        }
    }

    public static void main(String[] args) {
        // 테스트 데이터
        List<Student> students = Arrays.asList(
                new Student("김철수", 20, "컴퓨터공학", 3.8, Arrays.asList("Java", "Database", "Algorithm")),
                new Student("이영희", 22, "수학", 3.9, Arrays.asList("Calculus", "Statistics", "Linear Algebra")),
                new Student("박민수", 21, "컴퓨터공학", 3.2, Arrays.asList("Java", "Web Programming", "Database")),
                new Student("최지연", 23, "경영학", 3.7, Arrays.asList("Marketing", "Finance", "Management")),
                new Student("정태호", 19, "물리학", 4.0, Arrays.asList("Physics", "Mathematics", "Chemistry")),
                new Student("한서연", 20, "컴퓨터공학", 3.5, Arrays.asList("Python", "Machine Learning", "Statistics"))
        );

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 20, 25, 30);

        System.out.println("=== Stream API 실습 문제 ===");

        // 🟢 기초 문제 (1-10)

        // 문제 1: 컴퓨터공학과 학생들의 이름만 추출하세요.
        // 예상 결과: ["김철수", "박민수", "한서연"]
        System.out.println("\n문제 1:");
        // TODO: 여기에 코드 작성

        // 문제 2: 모든 학생의 이름을 대문자로 변환한 리스트를 만드세요.
        // 참고: 한글은 대문자 변환이 의미없으므로 그대로 출력됩니다.
        System.out.println("\n문제 2:");
        // TODO: 여기에 코드 작성

        // 문제 3: GPA가 3.5 이상인 학생이 있는지 확인하세요.
        // 예상 결과: true
        System.out.println("\n문제 3:");
        // TODO: 여기에 코드 작성

        // 문제 4: 모든 학생의 평균 나이를 계산하세요.
        // 예상 결과: 약 20.8
        System.out.println("\n문제 4:");
        // TODO: 여기에 코드 작성

        // 문제 5: 학생들을 GPA 내림차순으로 정렬한 리스트를 만드세요.
        // 예상 결과: 정태호(4.0) -> 이영희(3.9) -> 김철수(3.8) -> ...
        System.out.println("\n문제 5:");
        // TODO: 여기에 코드 작성

        // 문제 6: 나이가 21세 이상인 첫 번째 학생을 찾으세요.
        // 예상 결과: Optional[이영희(age=22, major=수학, gpa=3.9)]
        System.out.println("\n문제 6:");
        // TODO: 여기에 코드 작성

        // 문제 7: words 리스트에서 5글자 이상인 단어들만 필터링하세요.
        // 예상 결과: ["banana", "cherry", "elderberry", "grape"]
        System.out.println("\n문제 7:");
        // TODO: 여기에 코드 작성

        // 문제 8: numbers 리스트에서 짝수들의 제곱의 합을 구하세요.
        // 예상 결과: 2²+4²+6²+8²+10²+20²+30² = 1540
        System.out.println("\n문제 8:");
        // TODO: 여기에 코드 작성

        // 문제 9: 학생들을 전공별로 그룹화하세요.
        // 예상 결과: {컴퓨터공학=[김철수, 박민수, 한서연], 수학=[이영희], ...}
        System.out.println("\n문제 9:");
        // TODO: 여기에 코드 작성

        // 문제 10: 학생들이 수강하는 모든 과목의 중복을 제거한 리스트를 만드세요.
        // 예상 결과: ["Java", "Database", "Algorithm", "Calculus", ...]
        System.out.println("\n문제 10:");
        // TODO: 여기에 코드 작성

        // 🟡 중급 문제 (11-20)

        // 문제 11: 나이가 20세 이상이면서 GPA가 3.5 이상인 학생들의 이름을 알파벳 순으로 정렬하세요.
        System.out.println("\n문제 11:");
        // TODO: 여기에 코드 작성

        // 문제 12: 모든 학생이 수강하는 과목 중에서 'a'가 포함된 과목들만 추출하세요.
        // 예상 결과: ["Java", "Database", "Calculus", "Linear Algebra", ...]
        System.out.println("\n문제 12:");
        // TODO: 여기에 코드 작성

        // 문제 13: 전공별 학생 수를 계산하세요.
        // 예상 결과: {컴퓨터공학=3, 수학=1, 경영학=1, 물리학=1}
        System.out.println("\n문제 13:");
        // TODO: 여기에 코드 작성

        // 문제 14: 전공별 평균 GPA를 계산하세요.
        // 예상 결과: {컴퓨터공학=3.5, 수학=3.9, 경영학=3.7, 물리학=4.0}
        System.out.println("\n문제 14:");
        // TODO: 여기에 코드 작성

        // 문제 15: 각 전공별로 가장 높은 GPA를 가진 학생의 이름을 찾으세요.
        // 예상 결과: {컴퓨터공학="김철수", 수학="이영희", 경영학="최지연", 물리학="정태호"}
        System.out.println("\n문제 15:");
        // TODO: 여기에 코드 작성

        // 문제 16: GPA가 3.5 이상인 학생들을 전공별로 그룹화하되, 각 그룹에서 이름만 수집하세요.
        System.out.println("\n문제 16:");
        // TODO: 여기에 코드 작성

        // 문제 17: 학생들을 먼저 전공별로, 그 다음 GPA 내림차순으로 정렬하세요.
        System.out.println("\n문제 17:");
        // TODO: 여기에 코드 작성

        // 문제 18: numbers 리스트에서 10 이상인 수들의 개수, 합계, 평균, 최대값, 최소값을 모두 구하세요.
        System.out.println("\n문제 18:");
        // TODO: 여기에 코드 작성

        // 문제 19: 각 전공의 학생 이름들을 쉼표로 구분된 하나의 문자열로 만드세요.
        // 예상 결과: {컴퓨터공학="김철수,박민수,한서연", ...}
        System.out.println("\n문제 19:");
        // TODO: 여기에 코드 작성

        // 문제 20: 모든 컴퓨터공학과 학생이 Java 과목을 수강하는지 확인하세요.
        System.out.println("\n문제 20:");
        // TODO: 여기에 코드 작성

        // 🔴 고급 문제 (21-30)

        // 문제 21: 각 학생에 대해 "이름: 전공 (수강과목수: N개)" 형태의 문자열을 만들고, GPA 순으로 정렬하세요.
        // 예상 결과: ["정태호: 물리학 (수강과목수: 3개)", "이영희: 수학 (수강과목수: 3개)", ...]
        System.out.println("\n문제 21:");
        // TODO: 여기에 코드 작성

        // 문제 22: 학생들을 GPA 3.5를 기준으로 두 그룹으로 나누고, 각 그룹의 평균 나이를 구하세요.
        System.out.println("\n문제 22:");
        // TODO: 여기에 코드 작성

        // 문제 23: 학생들을 전공별로 그룹화한 후, 각 전공 내에서 다시 나이대(20세 미만, 20세 이상)로 그룹화하세요.
        System.out.println("\n문제 23:");
        // TODO: 여기에 코드 작성

        // 문제 24: 학생들의 GPA 분포를 계산하세요.
        // A등급(3.5 이상): N명, B등급(3.0~3.5): N명, C등급(3.0 미만): N명
        System.out.println("\n문제 24:");
        // TODO: 여기에 코드 작성

        // 문제 25: 1부터 100까지 숫자에서 소수의 개수를 병렬 스트림으로 구하세요.
        System.out.println("\n문제 25:");
        // TODO: 여기에 코드 작성 (isPrime 메서드도 구현 필요)

        // 문제 26: 가장 높은 GPA를 가진 학생의 첫 번째 수강 과목을 찾으세요. 없으면 "No course"를 반환.
        System.out.println("\n문제 26:");
        // TODO: 여기에 코드 작성

        // 문제 27: 피보나치 수열에서 1000보다 작은 짝수들만 추출하세요.
        // 힌트: Stream.iterate() 사용
        // 예상 결과: [0, 2, 8, 34, 144, 610]
        System.out.println("\n문제 27:");
        // TODO: 여기에 코드 작성

        // 문제 28: 각 전공별로 다음 정보를 담은 Map을 만드세요:
        // - 학생 수, 평균 GPA, 최고 GPA, 가장 많이 수강하는 과목 수
        System.out.println("\n문제 28:");
        // TODO: 여기에 코드 작성

        // 문제 29: 다음 단계를 거쳐 데이터를 변환하세요:
        // 1. GPA 3.0 이상인 학생만 필터링
        // 2. 각 학생의 수강 과목을 모두 추출
        // 3. 과목별 수강 학생 수 계산
        // 4. 수강 학생이 2명 이상인 과목만 선택
        // 5. 과목명을 알파벳 순으로 정렬
        System.out.println("\n문제 29:");
        // TODO: 여기에 코드 작성

        // 문제 30: numbers 리스트를 사용하여 다음을 계산하세요:
        // 1. 3의 배수들의 합
        // 2. 소수들의 개수
        // 3. 완전제곱수들의 제곱근
        // 4. 가장 큰 수와 가장 작은 수의 차이
        System.out.println("\n문제 30:");
        // TODO: 여기에 코드 작성
    }

    // 문제 25와 30에서 사용할 소수 판별 메서드
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 문제 30에서 사용할 완전제곱수 판별 메서드
    public static boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}