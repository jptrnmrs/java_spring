package test07;

public class Product {
    private String prodId;   // 상품 아이디
    private String prodName; // 상품 이름
    private int price;       // 상품 가격
    private int quantity;    // 재고 수량

    // 생성자
    public Product(String prodId, String prodName, int price, int quantity) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.price = price;
        this.quantity = quantity;
    }

    // 상품 정보 출력 메서드
    public void printProductInfo() {
        System.out.println("상품코드 : " + prodId + "\n" +
                           "상품이름 : " + prodName + "\n" +
                           "상품가격 : " + price +"\n"+
                           "재고수량 : " + quantity);
    }

}
