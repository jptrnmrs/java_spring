package sub1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/*
 * 날짜 : 2024. 7. 24.
 * 이름 : 김주경
 * 내용 : HTTTP 통신 실습
 */
public class HttpGetTest {
	public static void main(String[] args) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
										.uri(URI.create("https://naver.com"))
										.GET()
										.build();
		
		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("상태코드 : " + response.statusCode());
			System.out.println("응답내용 : " + response.statusCode());
		
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
