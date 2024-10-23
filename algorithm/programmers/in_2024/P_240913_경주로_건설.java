package Algorithm.algorithm.programmers.in_2024;
import java.util.*;
public class P_240913_경주로_건설 {
  public int solution(int[][] board) {
    int n = board.length;
    int answer = 0;
    // PriorityQueue<Node> pque = new PriorityQueue<>();
    Queue<Node> pque = new LinkedList<>();
    int[] yDir = {0,0,1,-1};
    int[] xDir = {1,-1,0,0};
    pque.offer(new Node(0,0,0,0));
    pque.offer(new Node(0,0,2,0));
    int[][][] costArr = new int[n][n][4];
    for(int i = 0 ; i < n ; i++){
      for(int j = 0 ; j < n ; j++){
        for(int k =0  ; k < 4 ; k++){
          costArr[i][j][k] = Integer.MAX_VALUE;
        }
      }
    }
    costArr[0][0][0] = 0;
    costArr[0][0][1] = 0;
    costArr[0][0][2] = 0;
    costArr[0][0][3] = 0;
    while(!pque.isEmpty()){
      Node node = pque.poll();
      // System.out.println(node);
      int y = node.y;
      int x = node.x;
      int dir = node.dir;
      int cost = node.cost;
      for(int i = 0 ; i < 4 ; i++){
        int nextY = y + yDir[i];
        int nextX = x + xDir[i];
        int nextCost = dir == i ? cost + 100 : cost + 500 + 100;
        if(nextY >= 0 && nextY < n && nextX >= 0 && nextX < n
                && board[nextY][nextX] == 0
                && nextCost <= costArr[nextY][nextX][i]){
          costArr[nextY][nextX][i] = nextCost;
          pque.offer(new Node(nextY,nextX,i,nextCost));
        }
      }
    }
    // for(int i = 0 ; i < n ; i++){
    //     System.out.println(Arrays.toString(costArr[i]));
    // }
    answer = Integer.MAX_VALUE;
    for(int i = 0 ; i < 4; i++){
      answer = Math.min(answer,costArr[n-1][n-1][i]);
    }
    return answer;
  }

  class Node implements Comparable{
    int y;
    int x;
    int dir;
    int cost;
    Node(int y, int x, int dir, int cost){
      this.y = y;
      this.x = x;
      this.dir = dir;
      this.cost = cost;
    }
    @Override
    public int compareTo(Object obj){
      if(obj instanceof Node){
        Node temp = (Node) obj;
        return this.cost - temp.cost;
      }
      return 0;
    }
    @Override
    public String toString(){
      return "y : " + y + " , x : " + x + " , dir : " + dir + ", cost : " + cost;
    }
  }
}
