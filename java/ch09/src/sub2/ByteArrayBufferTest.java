package sub2;

import java.io.*;
/*
 * 날짜 : 2024. 7. 18.
 * 이름 : 김주경
 * 내용 : 바이트 배열을 이용한 버퍼 실습
 */
public class ByteArrayBufferTest {
	public static void main(String[] args) {
		String source = "E:\\green\\workspace.zip";
		String target = "E:\\green\\workspace3.zip";

		// 버퍼로 이용한 byte 배열
		byte[] buffer = new byte[1024]; //1KB
		
		try {
			// 입력스트림 생성 및 파일 연결
			FileInputStream fis = new FileInputStream(source);
			FileOutputStream fos = new FileOutputStream(target);
			
			
			while (true) {
				// 파일 읽기
			
				int data = fis.read(buffer);	// 한번에 1KB단위로 읽기
				
				if(data == -1) {	// 더이상 읽어올 내용이 없을 때
					break;
				}
				
				// 파일 읽은 내용 그대로 출력
//				System.out.println(data);
				
				// 파일 쓰기
				fos.write(buffer, 0, data);
			}
			// 버퍼 비우기
			
			
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
