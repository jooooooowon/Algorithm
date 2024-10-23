package Algorithm.algorithm.programmers.in_2024;
import java.util.*;
public class P_240330_미로탈출 {
    int[][] arr;
    boolean[][] visited;
    int n,m,startY,startX,leverY,leverX,endY,endX;

    public int solution(String[] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length();
        arr = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            String str = maps[i];
            for(int j = 0 ; j < m ;j++){
                char ch = str.charAt(j);
                if(ch == 'S'){
                    startY = i;
                    startX = j;
                }
                if(ch == 'X'){
                    arr[i][j] = -1;
                }
                if(ch == 'L'){
                    leverY = i;
                    leverX = j;
                }
                if(ch == 'E'){
                    endY = i;
                    endX = j;
                }
            }
        }

        return bfs();
    }

    int bfs(){

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startY,startX));
        visited = new boolean[n][m];
        int[][] count = new int[n][m];
        int[] dirY = {1,-1,0,0};
        int[] dirX = {0,0,1,-1};
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(arr[now.y][now.x] == 1){
                break;
            }
            for(int i = 0 ; i < 4; i++){
                int nextY = now.y + dirY[i];
                int nextX = now.x + dirX[i];
                if(nextY >= 0 && nextY < n && nextX >= 0 && nextX < m
                        && !visited[nextY][nextX]
                        && arr[nextY][nextX] != -1){
                    visited[nextY][nextX] = true;
                    count[nextY][nextX] = count[now.y][now.x] + 1;
                    queue.offer(new Node(nextY,nextX));
                }
            }
        }
        if(!visited[leverY][leverX]) return -1;
        visited = new boolean[n][m];
        queue.offer(new Node(leverY,leverX));
        visited[leverY][leverX] = true;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(endY == now.y && endX == now.x){
                break;
            }
            for(int i = 0 ; i < 4 ; i++){
                int nextY = now.y + dirY[i];
                int nextX = now.x + dirX[i];
                if(nextY >= 0 && nextY < n && nextX >= 0 && nextX < m
                        && !visited[nextY][nextX] && arr[nextY][nextX] != -1){
                    visited[nextY][nextX] = true;
                    count[nextY][nextX] = count[now.y][now.x] + 1;
                    queue.offer(new Node(nextY,nextX));
                }
            }
        }
        if(visited[endY][endX]){
            return count[endY][endX];
        }
        return -1;
    }

    class Node{
        int y;
        int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

}
