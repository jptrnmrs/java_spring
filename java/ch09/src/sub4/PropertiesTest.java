package sub4;

import java.io.*;
import java.util.Properties;

/*
 * 날짜 : 2024. 7. 18.
 * 이름 : 김주경
 * 내용 : 프로퍼티 실습
 * 
 * 프로퍼티 (Properties)
 *  - 문자열 데이터만 취급하는 Key-value 자료구조 클래스
 *  - 직렬화, 역직렬화를 이용해 데이터를 입출력하는 자료구조 클래스
 *  - 프로그램 환경설정값을 저장할 때 많이 사용
 */
public class PropertiesTest {
	public static void main(String[] args) {
		// 프로퍼티 생성
		Properties prop = new Properties();
		prop.setProperty("A", "Apple");
		prop.setProperty("B", "Banana");
		prop.setProperty("C", "Cherry");
		
		System.out.println(prop);
		
		// 프로퍼티 직렬화 (파일저장)
		String path = "E:\\green\\fruit.properties";
		
		try {
			// 스트림 생성
			FileOutputStream fos = new FileOutputStream(path);
			
			// 직렬화
			prop.store(fos, null);
			
			// 스트림 해제
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/////////////////////////////////////////////
		// 프로퍼티 역직렬화(파일 읽기)
		String path2 = "E:\\green\\city.properties";
		Properties cityProp = new Properties();
		
		try {
			// 스트림 생성
			FileInputStream fis = new FileInputStream(path2);
			// 직렬화
			cityProp.load(fis);
			
			// 스트림 해제
			fis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(cityProp);
		System.out.println("한국 : " + cityProp.getProperty("kor"));
		System.out.println("일본 : " + cityProp.getProperty("jap"));
		System.out.println("중국 : " + cityProp.getProperty("chn"));
		
		
		System.out.println("프로그램 종료...");
		
	}
}
