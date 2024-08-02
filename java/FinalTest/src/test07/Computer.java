package test07;

public class Computer extends Product {
    private String manufactor; // 제조사

    // 생성자
    public Computer(String prodId, String prodName, int price, int quantity, String manufactor) {
        super(prodId, prodName, price, quantity); // 부모 클래스 생성자 호출
        this.manufactor = manufactor;
    }

    // 상품 정보 출력 메서드 (오버라이딩)
    @Override
    public void printProductInfo() {
        super.printProductInfo(); // 부모 클래스의 메서드 호출
        System.out.println("제조사 : " + manufactor);
    }
}
