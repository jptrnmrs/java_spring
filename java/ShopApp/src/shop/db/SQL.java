package shop.db;

public class SQL {

	public static final String INSERT_CUSTOMER ="insert into `customer` values (?,?,?,?,now())";
	public static final String SELECT_CUSTOMER ="select * from `customer` where `custId`=?";
	public static final String SELECT_CUSTOMERS ="select * from `customer`";
	public static final String UPDATE_CUSTOMER ="update `customer` set "
												+"`name`=?, `hp`=?, `addr`=?"
												+" where `custId` =?";
	public static final String DELETE_CUSTOMER ="delete from `customer` where `custId`=?";
	
	
	public static final String SELECT_PRODUCT ="select * from `product`";
	public static final String INSERT_ORDER ="insert into `Order` (`orderId`, `orderProduct`, `orderCount`, `orderDate`) values (?,?,?,now())";
	public static final String SELECT_ORDERS_BY_ORDERID
			= "select a.orderNo, a.orderProduct, b.prodName, a.orderCount, c.name, a.orderDate "
			+ "From `order`	   as a "
			+ "join `Product`  as b ON a.orderProduct = b.prodNo "
			+ "join `customer` as c ON a.orderId = c.custId "
			+ "Where `orderId`= ?";

	
}
