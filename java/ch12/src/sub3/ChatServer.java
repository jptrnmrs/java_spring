package sub3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 날짜 : 2024. 7. 24.
 * 이름 : 김주경
 * 내용 : 채팅 실습
 */
public class ChatServer {
	public static void main(String[] args) {
		System.out.println("[Server]");
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(50002);
			
			System.out.println("연결 대기");
			socket = serverSocket.accept();
			
			System.out.println("연결 수립");
			Thread t1 = new SendThread(socket);
			Thread t2 = new ReceiveThread(socket);
			
			t1.start();
			t2.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
