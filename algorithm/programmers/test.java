package Algorithm.algorithm.programmers;

import java.util.ArrayList;

public class test {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		testmethod(list);
		System.out.println("main : " + list);
	}
	
	private static void testmethod(ArrayList<Integer> list) {
		if(list.size() == 5) {
			return ;
		}
		ArrayList<Integer> tempList = (ArrayList<Integer>)list.clone();
		tempList.add(list.size());
		System.out.println(tempList.size() + " before tempList : " + tempList);
		testmethod(tempList);
		System.out.println(tempList.size() + " after tempList : " + tempList);
	}
}
