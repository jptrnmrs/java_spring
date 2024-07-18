package sub3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * 날짜 : 2024. 7. 18.
 * 이름 : 김주경
 * 내용 : 직렬화 실습 
 */
public class SerializeTest {
	public static void main(String[] args) {
		
		Apple apple = new Apple("한국",3000);
		String path = "E:\\green\\apple.txt";
		
		try {
			FileOutputStream fos = new FileOutputStream(path);
			
			// 직렬화 개체를 내보내기 위한 보조스트림
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			//객체 직렬화 (내보내기)
			oos.writeObject(apple);
			
			//스트림 해제
			oos.close();
			fos.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료...");
	}
}
