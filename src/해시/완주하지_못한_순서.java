package 해시;

import java.util.Arrays;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42576
 */
public class 완주하지_못한_순서 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        //참가자와 완주자 명단 이름순으로 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }

        //완주자 명단에 없으면 마지막 사람이 완주를 못함(완주 실패자는 단 1명)
        return participant[participant.length - 1];
    }

    public static void main(String[] args) {
        완주하지_못한_순서 test = new 완주하지_못한_순서();

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        String result = test.solution(participant, completion);

        System.out.println(result);
    }
}
