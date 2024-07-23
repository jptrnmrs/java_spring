package sub4;

import java.util.*;
import java.util.stream.Collectors;

/*
 * 날짜 : 2024. 7. 23.
 * 이름 : 김주경
 * 내용 : 자바 컬렉션 스트림 맵 실습
 */
class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
public class StreamMapTest {
	public static void main(String[] args) {

		//Person 리스트 생성
		List <Person> people = new ArrayList<Person>();
		people.add(new Person ("김유신",23));
		people.add(new Person ("김춘추",21));
		people.add(new Person ("장보고",33));
		people.add(new Person ("강감찬",43));
		people.add(new Person ("이순신",53));
		
		// map 스트림
		List<String> names = people.stream()
									.map((person)-> person.getName())
									//새로운 데이터 변환해서 다음 스트림으로 전달
									.collect(Collectors.toList());
									// 스트림으로 전송된 데이터 취합해 컬렉션으로 변환
		System.out.println(names);
		
		// flatMap 스트림
		List<List<String>> lists = List.of(
							Arrays.asList("apple","banana"),
							Arrays.asList("cherry","grape"),
							Arrays.asList("orange","mango")
						);
		System.out.println(lists);
		
		List<String> fruit = lists.stream()
								.flatMap((list)->list.stream())
								.collect(Collectors.toList());
		
		System.out.println(fruit);
		
		
		
		
		
	}
}
