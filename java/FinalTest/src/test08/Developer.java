package test08;

public class Developer extends Employee {
    private String field; // 개발 분야

    // 생성자
    public Developer(String name, String birth, String employeeId, String dept, int salary, String field) {
        super(name, birth, employeeId, dept, salary); // 부모 클래스(Employee)의 생성자 호출
        this.field = field;
    }

    // 개발 분야 변경 메서드
    public void changeField(String newField) {
        if (newField != null && !newField.isEmpty()) {
            field = newField;
            System.out.println("개발 분야가 " + newField + "(으)로 변경되었습니다.");
        } else {
            System.out.println("유효한 개발 분야를 입력하세요.");
        }
    }

    // 개발자 정보 출력 메서드
    public void printDeveloperInfo() {
        printEmployeeInfo(); // Employee 클래스의 메서드 호출
        System.out.println("개발 분야 : " + field);
    }

}
