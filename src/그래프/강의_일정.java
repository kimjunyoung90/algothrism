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
        // 필수 수강 강의 목록이 존재(numCourses)
        // 필수 강의를 듣기 위해서 먼저 들어야 하는 강의 목록이 존재함(prerequisites)

        //강의를 듣기 위해서는 먼저 들어야 하는 강의가 있는지 체크하는 것이 주요 관점이다.
        //먼저 들어야 하는 강의가 없는 경우에만 강의를 들을 수 있다.

        //선제적으로 들어야 하는 강의의 수
        int[] inDegree = new int[numCourses];
        List<List<Integer>> nextCourses = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            nextCourses.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int after = prerequisites[i][0];
            int pre = prerequisites[i][1];
            inDegree[after]++;
            nextCourses.get(pre).add(after);
        }

        Queue<Integer> taking = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0) {
                taking.offer(i);
            }
        }

        int taken = 0;
        while (!taking.isEmpty()) {
            int cur = taking.poll();
            taken++;
            for(int nextCourse : nextCourses.get(cur)) {
                inDegree[nextCourse]--;
                if(inDegree[nextCourse] == 0) {
                    taking.offer(nextCourse);
                }
            }
        }

        return taken == numCourses;
    }

    public static void main(String[] args) {
        강의_일정 test = new 강의_일정();

        boolean result1 = test.canFinish(2, new int[][]{{1, 0}});
        System.out.println(result1); // 기대값: true

        boolean result2 = test.canFinish(2, new int[][]{{1, 0}, {0, 1}});
        System.out.println(result2); // 기대값: false
    }
}
