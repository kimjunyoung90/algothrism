import java.util.*;

class 위장 {
    public int solution(String[][] clothes) {
        //조건 1 : 각 종류별 최대 1가지 의상 착용
        //조건 2 : 착용한 의상이 겹치더라도 다른 종류의 의상이 겹치지 않거나, 의상을 추가로 착용하면 다른 조합의 옷임
        //조건 3: 최소 1개의 옷 착용

        Map<String, Integer> clothCount = new HashMap<>();
        for(String[] cloth: clothes) {
			clothCount.merge(cloth[1], 1, Integer::sum);
        }

		return clothCount.values().stream()
				.reduce(1, (accm, current) -> accm * (current + 1)) - 1;
    }

    public static void main(String[] args) {
        위장 sol = new 위장();

        // 예제 1: 결과 5
        System.out.println(sol.solution(new String[][]{
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        }));

        // 예제 2: 결과 3
        System.out.println(sol.solution(new String[][]{
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
        }));
    }
}
