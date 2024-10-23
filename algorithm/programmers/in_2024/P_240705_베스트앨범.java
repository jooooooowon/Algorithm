package Algorithm.algorithm.programmers.in_2024;

import java.util.*;
public class P_240705_베스트앨범 {
  public int[] solution(String[] genres, int[] plays) {
    int n = genres.length;
    Map<String, Integer> genreMapPlays = new HashMap<>();
    Map<String, PriorityQueue<Node>> genreMapPlayPque = new HashMap<>();
    for(int i = 0; i < genres.length; i++){
      String genre = genres[i];
      int play = plays[i];

      genreMapPlays.put(genre, genreMapPlays.getOrDefault(genre,0) + play);
      PriorityQueue<Node> pque ;
      if(genreMapPlayPque.containsKey(genre)){
        pque = genreMapPlayPque.get(genre);
      }else{
        pque = new PriorityQueue<>();
      }
      pque.offer(new Node(i,play));
      genreMapPlayPque.put(genre,pque);
    }
    PriorityQueue<Integer> tempPque = new PriorityQueue<>(Collections.reverseOrder());
    Map<Integer,String> playMapGenre = new HashMap<>();
    for(String genre : genreMapPlays.keySet()){
      tempPque.offer(genreMapPlays.get(genre));
      playMapGenre.put(genreMapPlays.get(genre),genre);
    }

    String[] playsArr = new String[tempPque.size()];
    int size = 0;
    for(int i = 0 ; i < playsArr.length; i++){
      Integer play = tempPque.poll();

      playsArr[i] = playMapGenre.get(play);
      int temp = genreMapPlayPque.get(playsArr[i]).size();
      if(temp > 2) temp = 2;
      size += temp;
    }
    int[] result = new int[size];
    int index = 0;
    for(String genre : playsArr){
      PriorityQueue<Node> pque = genreMapPlayPque.get(genre);
      for(int i = 0; i < 2 ; i++){
        if(pque.isEmpty()){
          break;
        }
        result[index++] = pque.poll().index;
      }
    }
    return result;
  }

  class Node implements Comparable{
    int index;
    int play;

    public Node(int index, int play){
      this.index = index;
      this.play = play;
    }
    @Override
    public int compareTo(Object obj){
      Node node = (Node) obj;
      if(node.play == this.play){
        return this.index - node.index;
      }
      return node.play - this.play;
    }

    @Override
    public String toString(){
      return "index : " + index + " play : " + play;
    }
  }
}