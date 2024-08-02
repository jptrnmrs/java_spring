package test07;

public class Clothes extends Product {
    private String size; // 의류 사이즈

    // 생성자
    public Clothes(String prodId, String prodName, int price, int quantity, String size) {
        super(prodId, prodName, price, quantity); // 부모 클래스 생성자 호출
        this.size = size;
    }

    // 상품 정보 출력 메서드 (오버라이딩)
    @Override
    public void printProductInfo() {
        super.printProductInfo(); // 부모 클래스의 메서드 호출
        System.out.println("사이즈 : " + size);
    }
}
