package Algorithm.sasfy_algirithm_part.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWProblemSolve1230 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int test = 1 ; test <= 10 ; test++) {
			LinkedNodeLists list = new LinkedNodeLists();
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; i++) {
				list.lastInsert(Integer.parseInt(st.nextToken()));
			}
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; i++) {
				String str = st.nextToken();
				if(str.equals("I")) {
					int idx = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					for(int j = idx ; j < idx + num ; j++) {
						list.insert(j, Integer.parseInt(st.nextToken()));
					}
				}else if(str.equals("D")) {
					int idx = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					list.remove(idx,num);
				}else if(str.equals("A")) {
					int num = Integer.parseInt(st.nextToken());
					for(int j = 0 ; j < num; j++) {
						list.lastInsert(Integer.parseInt(st.nextToken()));
					}
				}
			}
			sb.append("#").append(test);
			for(int i = 0 ; i < 10; i++) {
				sb.append(" ").append(list.remove());
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	
	static class Node{
		int data;
		Node link;
		
		public Node() {
		}
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	static class LinkedNodeLists{
		Node head;
		int size;
		
		// 첫번째 삭제
		int remove() {
			int data = head.data;
			head = head.link;
			size--;
			return data;
		}
		
		// idx 번째 삭제
		int remove(int idx) {
			if(idx == 0) {
				return remove();
			}
			Node removeNode = getByIdx(idx);
			Node preNode = getByIdx(idx-1);
			preNode.link = removeNode.link;
			size--;
			return removeNode.data;
		}

		// start ~ end 삭제
		void remove(int start, int end) {
			while(0 < end) {
				end--;
			}
		}
		
		// 첫번째 삽입
		void firstInsert(int data){
			Node newNode = new Node(data);
			newNode.link = head;
			head = newNode;
			size++;
		}
		
		// 마지막 삽입
		void lastInsert(int data){
			Node newNode = new Node(data);
			Node originNode = getByIdx(size-1);
			if(originNode == null) {
				head = newNode;
			}else {
				originNode.link = newNode;
			}
			size++;
		}
		
		// 특정 index 삽입
		void insert(int idx, int data) {
			if(idx < 0 || idx >= size) {
				return ;
			}
			if(idx == 0) {
				firstInsert(data);
				return ;
			}
			Node pre = getByIdx(idx-1);
			Node newNode = new Node(data);
			newNode.link = pre.link;
			pre.link = newNode;
			size++;
			
		}
		
		// 특정 index 노드 뽑기.
		Node getByIdx(int idx) {
			if(idx < 0 || idx >= size) {
				return null;
			}
			
			Node curr = head;
			for(int i = 0 ; i < idx; i++) {
				curr = curr.link;
			}
			return curr;
		}
	}
}
