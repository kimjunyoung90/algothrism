package 그래프;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 강의_일정 (Course Schedule)
 *
 * numCourses 개의 강의(0 ~ numCourses-1)를 들어야 한다.
 * prerequisites[i] = [a, b] 는 강의 a 를 들으려면 먼저 강의 b 를 들어야 함을 의미한다.
 * 모든 강의를 끝마치는 것이 가능한지 true / false 로 반환한다.
 *
 * 제약조건:
 * - 1 <= numCourses <= 2000
 * - 0 <= prerequisites.length <= 5000
 * - prerequisites[i].length == 2
 * - 0 <= ai, bi < numCourses
 * - 모든 prerequisites[i] 쌍은 서로 다르다.
 *
 * @link https://leetcode.com/problems/course-schedule/
 */
public class 강의_일정 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // TODO(human): 구현하세요.

        int[] remainingPreClasses = new int[numCourses];

        //b라는 강의를 듣고 나서 들을 수 있는 강의를 확인
        List<List<Integer>> nextClasses = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            nextClasses.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int next = prerequisites[i][0];
            int pre = prerequisites[i][1];
            nextClasses.get(pre).add(next);
            //next을 듣기 위해서는 pre를 들어야함
            remainingPreClasses[next]++;
        }

        Queue<Integer> ready = new LinkedList<>();
        //먼저 들어야 하는 강의가 없는 것부터 듣기 -> 강의별 먼저 들어야 하는 강의가 몇개인지 세둠 = 위에 remainingPreClasses
        for (int i = 0; i < numCourses; i++) {
            if(remainingPreClasses[i] == 0) {
                ready.offer(i);
            }
        }
        //들은 강의는 중복 수강 방지(최적화)
        int finished = 0;
        while (!ready.isEmpty()) {
            int taken = ready.poll();
            // 강의 수강 시 들은 강의 remainingPreClasses 추가
            finished++;
            //이 강의를 수강했을 때 들을 수 있는 강의 확인
            for (int nextClass : nextClasses.get(taken)) {
                //들을 강의가 있던 강의들은 remainingPreClasses 감소 = a라는 강의를 먼저 들어야 하는 강의의 remainingPreClasses 감소
                remainingPreClasses[nextClass]--;

                //선수 강의 없으면 수강
                if(remainingPreClasses[nextClass] == 0) {
                    ready.offer(nextClass);
                }
            }
        }

        return finished == numCourses;
    }

    public static void main(String[] args) {
        강의_일정 test = new 강의_일정();

        boolean result1 = test.canFinish(2, new int[][]{{1, 0}});
        System.out.println(result1); // 기대값: true

        boolean result2 = test.canFinish(2, new int[][]{{1, 0}, {0, 1}});
        System.out.println(result2); // 기대값: false
    }
}
