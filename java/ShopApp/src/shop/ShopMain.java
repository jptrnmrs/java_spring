package shop;

import java.util.List;
import java.util.Scanner;

import shop.dao.CustomerDAO;
import shop.dao.OrderDAO;
import shop.dao.ProductDAO;
import shop.vo.CustomerVO;
import shop.vo.OrderVO;
import shop.vo.ProductVO;

/*
 * 날짜 : 2024. 7. 31.
 * 이름 : 김주경
 * 내용 : shop 미니 프로젝트 실습
 */
public class ShopMain {
	public static void main(String[] args) {
		System.out.println("-----------------------------------------------------");
		System.out.println("\t\t쇼핑몰에 오신 것을 환영합니다.");
		System.out.println("-----------------------------------------------------");
		
		Scanner in =  new Scanner(System.in);
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		ProductDAO	prodDAO = ProductDAO.getInstance();
		OrderDAO orderDAO = OrderDAO.getInstance();
		CustomerVO loginedCustomer=null;
		while(true) {
			if(loginedCustomer==null) {
				System.out.println("\t로그인:1, 회원가입:2, 상품목록:3, 주문하기:4");
			}else {
				System.out.println("\t로그아웃:1, 주문현황:2, 상품목록:3, 주문하기:4");
			}
			System.out.println("\t\t종료하려면 음수를 입력하세요.");
			System.out.print("\t\t\t선택> ");
			int answer = in.nextInt();
			if(answer<0) break;
			else if(answer==1){
				if(loginedCustomer==null) {
					// 로그인
					System.out.print("\t\t아이디 입력 : ");
					String custId = in.next();
					
					loginedCustomer = customerDAO.searchCustomer(custId);
					
					if (loginedCustomer != null) {
						System.out.println("\t\t"+loginedCustomer.getName()+ " 님 어서 오십시오.");
					} else {
						System.out.println("\t\t등록된 회원이 아닙니다!");
					}
				}else {
					// 로그아웃
					System.out.println("\t\t"+loginedCustomer.getName()+" 님 안녕히 가세요");
					loginedCustomer = null;
				}
				System.out.println("-----------------------------------------------------");
				
			}else if(answer==2){
				if(loginedCustomer==null) {
					// 회원가입
					CustomerVO cust = new CustomerVO();
					System.out.print("\t\t아이디 입력 : ");
					cust.setCustId(in.next());
					System.out.print("\t\t이름 입력 : ");
					cust.setName(in.next());
					System.out.print("\t\t휴대폰 입력 : ");
					cust.setHp(in.next());
					System.out.print("\t\t주소 입력 : ");
					cust.setAddr(in.next());
					
					int result = customerDAO.insertCustomer(cust);
					if(result>0) System.out.println("\t\t회원가입이 완료되었습니다.");
					else System.out.println("\t\t가입에 실패하셨습니다.");
				}else {
					List<OrderVO> myOrder = orderDAO.myOrder(loginedCustomer.getCustId());

					System.out.println("-----------------------------------------------------");
					System.out.println("No |   상품명\t| 수량 | 주문자\t| 주문일자");
					System.out.println("-----------------------------------------------------");
					for(OrderVO order : myOrder) {
						int orderNo = order.getOrderNo();
						int prodNo = order.getOrderProduct();
						String prodName = order.getProdName();
						int orderCount = order.getOrderCount();
						String custName = order.getOrderName();
						String orderDate = order.getOrderDate().substring(2);
						System.out.println(orderNo + " | "+prodNo+" | "+prodName+"\t| "+orderCount+"개 | "
								+custName+"\t| "+orderDate);
					}
					//주문현황 (주문번호, 상품번호, 상품명, 주문수량, 주문자 이름, 주문일자)
					
				}
				System.out.println("-----------------------------------------------------");
			}else if(answer==3){
				// 상품목록
				List<ProductVO> prodList = prodDAO.showProduct();
				System.out.println("-----------------------------------------------------");
				System.out.println(" No | 상품명 \t| 가격 \t| 재고수량\t| 제조사");
				System.out.println("-----------------------------------------------------");
//				for(ProductVO prod : prodList) System.out.println(prod);
				prodList.stream().forEach(System.out::println);
				System.out.println("-----------------------------------------------------");
				
			}else if(answer==4){
				// 주문하기
				if(loginedCustomer==null) {
					System.out.println("\t\t비회원은 주문할 수 없습니다!");
					System.out.println("-----------------------------------------------------");
					continue;
				}else {
					System.out.print("\t\t주문할 상품 번호 : ");
					int prodNo = in.nextInt();
					System.out.print("\t\t\t수량 : ");
					int orderCount = in.nextInt();
					OrderVO order = new OrderVO(loginedCustomer.getCustId(), prodNo, orderCount);
					int result = orderDAO.insertOrder(order);
					
					if(result>0) System.out.println("\t\t주문이 완료되었습니다.");
					else System.out.println("\t\t주문할 수 없습니다!");
					System.out.println("-----------------------------------------------------");
				}
				
			}else{
				System.out.println("\t\t잘못된 입력입니다.");
				continue;
			}
			
		}
		in.close();
		System.out.println("-----------------------------------------------------");
		System.out.println("\t\t\t안녕히 가십시오.");
		System.out.println("-----------------------------------------------------");
	}
}
