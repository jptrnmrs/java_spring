package sub3;

import java.util.LinkedList;
import java.util.List;

/*
 * 날짜 : 2024. 7. 17.
 * 이름 : 김주경
 * 내용 : LinkedList 실습
 */
public class LinkedListTest {
	public static void main(String[] args) {
		
		// LinkedList 생성
		List<String> cities = new LinkedList<>();
		cities.add("서울");
		cities.add("대전");
		cities.add("대구");
		cities.add("부산");
		cities.add("광주");
		
		System.out.println(cities);
	}
}
