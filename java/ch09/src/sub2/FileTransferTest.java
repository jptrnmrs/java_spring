package sub2;

import java.io.*;
/*
 * 날짜 : 2024. 7. 18.
 * 이름 : 김주경
 * 내용 : 파일 메서드를 이용한 파일 복사 실습
 */
public class FileTransferTest {
	public static void main(String[] args) {
		String source = "E:\\green\\workspace.zip";
		String target = "E:\\green\\workspace2.zip";

		
		try {
			// 입력스트림 생성 및 파일 연결
			FileInputStream fis = new FileInputStream(source);
			FileOutputStream fos = new FileOutputStream(target);
			
			
			fis.transferTo(fos);
			
			// 스트림 해제
			
			fis.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램 종료...");
	}
}
