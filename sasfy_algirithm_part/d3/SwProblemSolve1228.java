package Algorithm.sasfy_algirithm_part.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwProblemSolve1228 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int test = 1 ; test <= 10 ; test++) {
			LinkedNodeList list = new LinkedNodeList();
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; i++) {
				list.lastInsert(Integer.parseInt(st.nextToken()));
			}
			n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			String[] strArr = str.split("I");
			for(int i = 1 ; i <= n ; i++) {
				st = new StringTokenizer(strArr[i]);
				int idx = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				for(int j = idx ; j < count+idx ; j++) {
					int data = Integer.parseInt(st.nextToken());
					list.insert(j, data);
				}
			}
			sb.append("#").append(test);
			for(int i = 0 ; i < 10 ; i++) {
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
	
	static class LinkedNodeList{
		Node head;
		int size;
		
		int remove() {
			int data = head.data;
			head = head.link;
			return data;
		}
		
		void firstInsert(int data){
			Node newNode = new Node(data);
			newNode.link = head;
			head = newNode;
			size++;
		}
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
		void insert(int idx, int data) {
			if(idx < 0 || idx >= size) {
				return ;
			}
			if(idx == 0) {
				firstInsert(data);
				size++;
				return ;
			}
			Node pre = getByIdx(idx-1);
			Node newNode = new Node(data);
			newNode.link = pre.link;
			pre.link = newNode;
			size++;
			
		}
		
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
