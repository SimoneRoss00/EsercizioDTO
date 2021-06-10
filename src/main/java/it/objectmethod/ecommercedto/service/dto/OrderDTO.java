package it.objectmethod.ecommercedto.service.dto;

public class OrderDTO {

	private Long orderId;

	private String orderNumber;

	private String dateOrder;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(String dateOrder) {
		this.dateOrder = dateOrder;
	}

	@Override
	public String toString() {
		return orderId + ";" + orderNumber + ";" + dateOrder;
	}

//	public OrderDTO articoloFactoryFromCsv(String line) throws ParseException {
//		DateFormat formatter = new SimpleDateFormat("yy-MM-dd");
//		String[] lineSplitted = line.split(";");
//		OrderDTO orderDTO = new OrderDTO();
//		orderDTO.orderId = Long.parseLong(lineSplitted[0]);
//		orderDTO.orderNumber = lineSplitted[1];
//		orderDTO.dateOrder = formatter.parse(lineSplitted[2]);
//		return orderDTO;
//	}

}
