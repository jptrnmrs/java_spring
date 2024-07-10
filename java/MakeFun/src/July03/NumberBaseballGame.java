package July03;
import java.util.*;

public class NumberBaseballGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 컴퓨터가 생각하는 숫자 생성 (중복 없는 3자리 숫자)
        int[] computerNumbers = generateRandomNumbers();

        System.out.println("숫자야구 게임을 시작합니다! 컴퓨터가 숫자를 생각했습니다.");

        int[] userNumbers = new int[3]; // 사용자가 입력할 숫자 배열

        // 게임 시작
        while (true) {
            // 사용자에게 숫자 입력 받기
            System.out.print("세 자리 숫자를 입력하세요 (중복 없이): ");
            int userInput = scanner.nextInt();

            // 입력받은 숫자를 각 자리별로 분리하여 배열에 저장
            userNumbers[0] = userInput / 100;       // 백의 자리 숫자
            userNumbers[1] = (userInput / 10) % 10; // 십의 자리 숫자
            userNumbers[2] = userInput % 10;        // 일의 자리 숫자

            // 스트라이크, 볼 판정
            int strikes = 0;
            int balls = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (userNumbers[i] == computerNumbers[j]) {
                        if (i == j) {
                            strikes++;
                        } else {
                            balls++;
                        }
                    }
                }
            }

            // 결과 출력
            if (strikes == 3) {
                System.out.println("정답입니다! 게임을 종료합니다.");
                break;
            } else if (strikes == 0 && balls == 0) {
                System.out.println("아웃입니다.");
            } else {
                System.out.println(strikes + "S " + balls + "B");
            }
        }

        scanner.close();
    }

    // 중복 없는 세 자리 숫자 생성 메소드
    public static int[] generateRandomNumbers() {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        int[] result = new int[3];

        // 1부터 9까지의 숫자를 리스트에 추가
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }

        // 리스트에서 중복 없이 세 개의 숫자를 랜덤하게 추출하여 배열에 저장
        Collections.shuffle(numbers);
        for (int i = 0; i < 3; i++) {
            result[i] = numbers.get(i);
        }

        return result;
    }
}
