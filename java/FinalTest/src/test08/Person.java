package test08;

public class Person {
    private String name; // 이름
    private String birth; // 생년월일

    // 생성자
    public Person(String name, String birth) {
        this.name = name;
        this.birth = birth;
    }

    // 사람 정보 출력 메서드
    public void printPersonInfo() {
        System.out.println("이름 : " + name);
        System.out.println("생년월일 : " + birth);
    }
}
