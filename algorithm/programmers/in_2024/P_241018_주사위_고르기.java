package Algorithm.algorithm.programmers.in_2024;
import java.util.*;

public class P_241018_주사위_고르기 {
  int n;
  int[] diceA;
  int[][] dice;
  Map<int[], List<Integer>> map = new HashMap<>();

  public int[] solution(int[][] dice) {
    this.dice = dice;
    int[] answer = new int[n/2];
    n = dice.length;
    diceA = new int[n/2];
    findDice(0,0);
    List<int[]> list = new ArrayList<>();
    for(int[] temp : map.keySet()){
      list.add(temp);
    }
    int winScore = 0;
    Set<int[]> set = new HashSet<>();

    for(int i = 0 ; i < list.size(); i++){
      int[] arr1 = list.get(i);
      for(int j = 0 ; j < list.size(); j++){
        int tempWinScore = 0;
        int[] arr2 = list.get(j);
        boolean tf = true;
        for(int num1 : arr1){
          for(int num2 : arr2){
            if(num1 == num2){
              tf = false;
              break;
            }
          }
          if(!tf) break;
        }
        if(!tf) continue;

        if(!set.contains(arr1)){
          Collections.sort(map.get(arr1));
          set.add(arr1);
        }
        if(!set.contains(arr2)){
          Collections.sort(map.get(arr2));
          set.add(arr2);
        }
        List<Integer> list1 = map.get(arr1);
        List<Integer> list2 = map.get(arr2);
        for(int k = 0 ; k < list1.size(); k++){
          int num = list1.get(k);
          int start = 0;
          int end = list2.size() - 1;
          int tempSum = 0;
          while(start <= end){
            int mid = (start + end) / 2;
            if(num > list2.get(mid)){
              tempSum = mid + 1;
              start = mid + 1;
            }else if(num <= list2.get(mid)){
              end = mid - 1;
            }
          }
          tempWinScore += tempSum;
        }


        if(winScore < tempWinScore){
          winScore = tempWinScore;
          answer = arr1;
        }
        // winScore = Math.max(winScore, tempWinScore);
      }
    }
    for(int i = 0 ; i < answer.length; i++){
      answer[i]++;
    }
    return answer;
  }

  void findDice(int idx, int depth){
    if(depth == n/2){
      int[] temp = Arrays.copyOf(diceA, diceA.length);
      map.put(temp, new ArrayList<>());
      sum(0,0,temp);
      return ;
    }
    for(int i = idx ; i < n ; i++){
      diceA[depth] = i;
      findDice(i + 1, depth + 1);
    }
  }
  void sum(int num, int depth, int[] temp){
    if(depth == n/2){
      map.get(temp).add(num);
      return ;
    }

    for(int i = 0 ; i < 6 ; i++){
      sum(num + dice[temp[depth]][i], depth + 1, temp);
    }
  }

}
