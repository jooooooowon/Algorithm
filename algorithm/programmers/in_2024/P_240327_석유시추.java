package Algorithm.algorithm.programmers.in_2024;

import java.util.*;

public class P_240327_석유시추 {
    int[][] arr;
    int[][] oil;
    Map<Integer, Integer> map = new HashMap<>();
    int n;
    int m;

    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        arr = land;
        oil = new int[n][m];
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && oil[i][j] == 0) {
                    bfs(i, j, num++);
                }
            }
        }
        for (Integer temp : map.keySet()) {
            System.out.println(map.get(temp) + " ");
        }
        for (int j = 0; j < m; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (oil[i][j] != 0) {
                    set.add(oil[i][j]);
                }
            }
            int temp = 0;
            for (Integer oilNumber : set) {
                temp += map.get(oilNumber);
            }
            answer = Math.max(answer, temp);
        }
        return answer;
    }

    int[] dirY = {1, -1, 0, 0};
    int[] dirX = {0, 0, 1, -1};

    public void bfs(int y, int x, int num) {
        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(y, x));
        oil[y][x] = num;
        while (!queue.isEmpty()) {
            count++;
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = node.y + dirY[i];
                int nextX = node.x + dirX[i];
                if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m && arr[nextY][nextX] == 1 && oil[nextY][nextX] == 0) {
                    oil[nextY][nextX] = num;
                    queue.offer(new Node(nextY, nextX));
                }
            }
        }
        map.put(num,count);
    }

    class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
