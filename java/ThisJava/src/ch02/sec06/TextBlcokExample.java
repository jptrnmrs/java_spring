package ch02.sec06;
/*
 * 장제목 : 2장 문자열타입
 * 이름 : 최형욱
 * 작성일 : 2023.12.27
 */
public class TextBlcokExample {

	public static void main(String[] args) {
		String str1 = "" + "{\n" + "\t\"id\":\"winter\",\n" + "\t\"name\":\"눈송이\",\n" + "}";
		
		String str2 = """
				{
					"id":"winter"
					"name":"눈송이"
				}
				""";
		
		System.out.println(str1);
		System.out.println("------------------------------");
		System.out.println(str2);
		System.out.println("------------------------------");
		String str = """
				나는 자바를 \
				학습합니다.
				나는 자바 고수가 될 겁니다.
				""";
		System.out.println(str);
	}

}
