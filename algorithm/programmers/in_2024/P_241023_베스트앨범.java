package Algorithm.algorithm.programmers.in_2024;

import java.util.*;
public class P_241023_베스트앨범 {
  public int[] solution(String[] genres, int[] plays) {
    // int[] answer = {};
    int n = genres.length;
    Map<String,Integer> mapCount = new HashMap<>();
    Map<String, List<Node>> mapList = new HashMap<>();
    for(int i = 0 ; i < n ; i++){
      mapCount.put(genres[i], mapCount.getOrDefault(genres[i],0) + plays[i]);
      List tempList;
      if(!mapList.containsKey(genres[i])){
        tempList = new ArrayList<>();
      }else{
        tempList = mapList.get(genres[i]);
      }
      tempList.add(new Node(plays[i],i));
      mapList.put(genres[i],tempList);
    }
    List<String> genreList = new ArrayList<>(mapCount.keySet());
    Collections.sort(genreList,(k1,k2) -> mapCount.get(k2) - mapCount.get(k1));
    List<Integer> result = new ArrayList<>();
    for(String genre : genreList){
      Collections.sort(mapList.get(genre), (m1,m2) -> m2.plays - m1.plays);
      for(int i = 0 ; i < mapList.get(genre).size(); i++){
        if(i == 2){
          break;
        }
        result.add(mapList.get(genre).get(i).idx);
      }
    }
    int[] answer = new int[result.size()];
    for(int i = 0; i < answer.length; i++){
      answer[i] = result.get(i);
    }
    return answer;
  }
  class Node{
    int plays;
    int idx;
    Node(int plays, int idx){
      this.plays = plays;
      this.idx = idx;
    }
    @Override
    public String toString(){
      return "plays : " + plays + " idx : " + idx;
    }
  }
}
