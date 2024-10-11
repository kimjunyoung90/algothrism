package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/2667
 */
public class 단지번호붙이기 {

    static int 단지수 = 0;
    static int width = 0;
    static boolean[][] houses;
    static boolean[][] visited;            //상,하,좌,우
    static List<Integer> 단지구성아파트수 = new ArrayList<>();
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());

        houses = new boolean[width][width];
        visited = new boolean[width][width];

        //집 정보 초기화
        for (int i = 0; i < width; i++) {
            String housesByLine = br.readLine();
            for (int j = 0; j < width; j++) {
                if(housesByLine.charAt(j) == '1'){
                    houses[i][j] = true;
                }
            }
        }

        //단지 구성 탐색
        for(int x = 0; x < width; x++){
            for(int y = 0; y < width; y++){
                if(houses[x][y] && !visited[x][y]){
                    단지구성아파트수.add(0);
                    탐색(x, y);
                    단지수++;
                }
            }
        }

        System.out.println(단지수);
        Collections.sort(단지구성아파트수);
        for (Integer 아파트수 : 단지구성아파트수) {
            System.out.println(아파트수);
        }
    }

    private static void 탐색(int x, int y) {
        visited[x][y] = true;
        단지구성아파트수.set(단지수, 단지구성아파트수.get(단지수) + 1);

        //상하좌우 조사
         for (int i = 0; i < 4; i++) {
              int targetX = x + dx[i];
              int targetY = y + dy[i];

             if((targetX >= 0 && targetX < width) && (targetY >= 0 && targetY < width) && houses[targetX][targetY] && !visited[targetX][targetY]) {
                탐색(targetX, targetY);
            }
        }
    }
}
