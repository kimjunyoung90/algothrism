package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 안테나 (이코테 - 정렬)
 * 안테나로부터 모든 집까지의 거리의 총 합이 최소가 되는 위치를 출력한다.
 * 여러 답이 가능하면 가장 작은 값을 출력한다.
 */
public class 안테나 {

    public int solution(int[] houses) {
        // TODO(human): 정렬된 houses 배열에서 거리 총합이 최소가 되는 위치를 골라 반환
        Arrays.sort(houses);
        int min = Integer.MAX_VALUE;
        int result = 0;
        //1. 안테나 위치로 부터 각 집의 거리 구하기
        for (int i = 0; i < houses.length; i++) {
            int distance = getDistance(houses[i], houses);
            if(distance < min) {
                result = houses[i];
                min = distance;
            }
        }
        return result;
    }

    public int getDistance(int antenna, int[] houses) {
        int distance = 0;
		for (int house : houses) {
			distance += Math.abs(house - antenna);
		}
        return distance;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine().trim());

//        int[] houses = new int[n];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            houses[i] = Integer.parseInt(st.nextToken());
//        }

        안테나 test = new 안테나();
        int[] houses = {5, 1, 7, 9};
        System.out.println(test.solution(houses));
    }
}
