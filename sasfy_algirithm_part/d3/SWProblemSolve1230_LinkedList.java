package Algorithm.sasfy_algirithm_part.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWProblemSolve1230_LinkedList {
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
				// I가 나오면 특정 index에 insert
				if(str.equals("I")) {
					int idx = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					for(int j = idx ; j < idx + num ; j++) {
						list.insert(j, Integer.parseInt(st.nextToken()));
					}
					// D가 나오면 delete
				}else if(str.equals("D")) {
					int idx = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					list.remove(idx,num);
					// A가 나오면 마지막에 넣기.
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
		// 노드가 갖고 있는 data
		int data;
		// 다음 노드로 연결되는 link
		Node link;
		
		public Node() {
		}
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	// 단방향 링크리스트.
	static class LinkedNodeLists{
		// 현재 리스트의 제일 맨 앞에 있는 노드
		Node head;
		// 현재 리스트의  size
		int size;
		
		// 첫번째 삭제
		int remove() {
			// 첫번째 데이터를 반환하기 위해 저장.
			int data = head.data;
			// 현재 헤드를 헤드 다음에 연결되어 있는 노드로 변경.
			head = head.link;
			// 사이즈 줄이기.
			size--;
			return data;
		}
		
		// idx 번째 삭제
		int remove(int idx) {
			// 첫번째 삭제
			if(idx == 0) {
				return remove();
			}
			// 지울 노드
			Node removeNode = getByIdx(idx);
			// 지울 노드의 전 노드
			Node preNode = getByIdx(idx-1);
			// 지울 노드의 전 노드의 연결 노드를 지울 노드의 연결 노드로 한다.
			preNode.link = removeNode.link;
			// 사이즈 줄이기
			size--;
			return removeNode.data;
		}

		// start ~ end 삭제
		void remove(int start, int end) {
			while(0 < end) {
				// end는 갯수, 갯수 만큼 start index의 노드를 제거한다.
				remove(start);
				end--;
			}
		}
		
		// 첫번째 삽입
		void firstInsert(int data){
			Node newNode = new Node(data);
			// 새로운 노드의 링크를 head로 하고
			newNode.link = head;
			// head를 새로운 노드로 한다.
			head = newNode;
			size++;
		}
		
		// 마지막 삽입
		void lastInsert(int data){
			Node newNode = new Node(data);
			Node originNode = getByIdx(size-1);
			// size가 0이라면
			if(originNode == null) {
				head = newNode;
			}else {
				// 0이 아니라면 원래 있던 링크를 새로운 노드로 한다.
				originNode.link = newNode;
			}
			size++;
		}
		
		// 특정 index 삽입
		void insert(int idx, int data) {
			if(idx < 0 || idx >= size) {
				return ;
			}
			// 0 이면 첫번째에 넣는다.
			if(idx == 0) {
				firstInsert(data);
				return ;
			}
			Node pre = getByIdx(idx-1);
			Node newNode = new Node(data);
			// 새로운 노드의 링크를 현재 index의 전 노드의 링크로 연결하고
			newNode.link = pre.link;
			// 현재 index의 전 노드의 링크를 새로운 노드로 한다.
			pre.link = newNode;
			size++;
			
		}
		
		// 특정 index 노드 뽑기.
		Node getByIdx(int idx) {
			// 범위가 넘간다면 null
			if(idx < 0 || idx >= size) {
				return null;
			}
			// index의 노드를 찾는다.
			Node curr = head;
			for(int i = 0 ; i < idx; i++) {
				curr = curr.link;
			}
			return curr;
		}
	}
}
