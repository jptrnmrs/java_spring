package test08;

public class Employee extends Person {
    private String employeeId; // 직원 아이디
    private String dept; // 부서
    private int salary; // 급여

    // 생성자
    public Employee(String name, String birth, String employeeId, String dept, int salary) {
        super(name, birth); // 부모 클래스(Person)의 생성자 호출
        this.employeeId = employeeId;
        this.dept = dept;
        this.salary = salary;
    }

    // 급여 인상 메서드
    public void raiseSalary(int amount) {
        if (amount > 0) {
            salary += amount;
            System.out.println("급여가 " + amount + "만큼 인상되었습니다.");
        } else {
            System.out.println("급여 인상 금액은 양수여야 합니다.");
        }
    }

    // 부서 변경 메서드
    public void changeDepartment(String newDept) {
        if (newDept != null && !newDept.isEmpty()) {
            dept = newDept;
            System.out.println("부서가 " + newDept + "(으)로 변경되었습니다.");
        } else {
            System.out.println("유효한 부서명을 입력하세요.");
        }
    }

    // 직원 정보 출력 메서드
    public void printEmployeeInfo() {
        printPersonInfo(); // Person 클래스의 메서드 호출
        System.out.println("직원 아이디 : " + employeeId);
        System.out.println("부서 : " + dept);
        System.out.println("급여 : " + salary);
    }

}
