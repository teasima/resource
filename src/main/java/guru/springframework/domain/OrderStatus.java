package guru.springframework.domain;

public enum OrderStatus {

	CANCELLED("CANCELLED"), UNPAID("UNPAID"), PAID("PAID"),SHIPPED("SHIPPED"), FINISHED("FINISHED");

	private String code;

	private OrderStatus(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return code;
	}

	public static OrderStatus parseCode(String code) {
		for (OrderStatus s : OrderStatus.values()) {
			if (s.code.equalsIgnoreCase(code))
				return s;
		}
		return null;
	}

}
